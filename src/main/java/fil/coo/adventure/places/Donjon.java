package fil.coo.adventure.places;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import fil.coo.adventure.places.directions.Direction;
import fil.coo.adventure.places.entity.EnumRoom;
import fil.coo.adventure.places.entity.StartingRoom;

public class Donjon {

    private int nbRoom;

    // Constructeur
    public Donjon(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    // Générer la map
    public Room generateMap() {

        Map<Integer, Room> rooms = new HashMap<Integer, Room>();
        Random rand = new Random();
        // generate random tiles
        for (int i = 0; i < this.nbRoom; i++) {
            double roomCoef = 0.0;
            double roomOldCoef = 0.0;
            double generatedNumber = rand.nextDouble();
            Room lastObject = EnumRoom.SLIME.getRoom();
            EnumRoom[] possibleValues = EnumRoom.values();
            for (EnumRoom object : possibleValues) {
                roomCoef += object.getSpawnCoef();
                if (generatedNumber >= roomOldCoef && generatedNumber < roomCoef) {
                    lastObject = object.getRoom();
                }
                roomOldCoef += object.getSpawnCoef();
            }
            lastObject.setName("Room " + String.valueOf(i));
            rooms.put(i, lastObject);
        }

        StartingRoom startRoom = new StartingRoom("Starting Room");
        // generate between 1 and 4 neighbour for our Starting room
        // generate adjacent rooms to the starting one
        Boolean bool = true;
        while (bool) {
            Direction direction = Direction.alea();
            // if our room already have a neighbour in this direction, change direction
            if (startRoom.getNeighbour(direction) != null) {
                break;
            }
            Room room = rooms.get(0);
            // if the room dont have a neighbour in the opposite direction, link the 2
            if (room.getNeighbour(direction.opposite()) == null) {
                startRoom.addNeighbour(direction, room);
                room.addNeighbour(direction.opposite(), startRoom);
                bool = false;
            }
        }

        // fill empty rooms
        for (Room room : rooms.values()) {
            // If a room is have no neighbour yet, give him a random linked one
            if (room.getPossibleDirections().size() == 0) {
                linkRoom(room, rooms);
            }
        }

        Exit exit = new Exit("Exit");
        Shop shop = new Shop("Shop");
        linkRoom(exit, rooms);
        linkRoom(shop, rooms);

        return startRoom;
    }

    private void linkRoom(Room room, Map<Integer, Room> rooms) {
        Random rand = new Random();
        Boolean bool = true;
        Room roomToLink;
        int roomToLinkKey = 0;
        while (bool) {
            roomToLinkKey = rand.nextInt(this.nbRoom - 1);
            roomToLink = rooms.get(roomToLinkKey);
            // Get out of loop is the randomly selected room is full or is not currently
            // linked to an other one.
            if (roomToLink.getPossibleDirections().size() != 4 && roomToLink.getPossibleDirections().size() != 0) {
                bool = false;
            }
            // If randomly selected room is the same as the room we try to link continue the
            // loop
            if (roomToLink == room) {
                bool = true;
            }
        }
        roomToLink = rooms.get(roomToLinkKey);
        bool = true;
        while (bool) {
            Direction direction = Direction.alea();
            // If the roomToLink dont have a neighbour in the selected direction and our
            // current room in the opposite direction
            if (roomToLink.getNeighbour(direction) == null && room.getNeighbour(direction.opposite()) == null) {
                roomToLink.addNeighbour(direction, room);
                room.addNeighbour(direction.opposite(), roomToLink);
                bool = false;
            }
        }
    }
}
