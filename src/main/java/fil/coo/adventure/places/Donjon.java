package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                roomCoef += object.getCoef();
                if (generatedNumber >= roomOldCoef && generatedNumber < roomCoef) {
                    lastObject = object.getRoom();
                }
                roomOldCoef += object.getCoef();
            }
            lastObject.setName("Room " + String.valueOf(i));
            rooms.put(i, lastObject);
        }

       
        StartingRoom startRoom = new StartingRoom("Starting Room");
        List<Room> roomUsed = new ArrayList<Room>();
        int nbAl = rand.nextInt(3) + 1;
        // generate adjacent room to the starting one
        while (nbAl != 0) {
            Direction direction = Direction.alea();
            if (startRoom.getNeighbour(direction) != null) {
                break;
            }
            for (Room room : rooms.values()) {
                if (room.getNeighbour(direction.opposite()) == null) {
                    startRoom.addNeighbour(direction, room);
                    room.addNeighbour(direction.opposite(), startRoom);
                    roomUsed.add(room);
                    nbAl--;
                    break;
                }
            }
        }

        System.out.println(startRoom.getName());
        System.out.println(startRoom.getPossibleDirections());

        // fill empty rooms
        for (Room room : rooms.values()) {
            if (room.getPossibleDirections().size() == 0) {
                linkRoom(room, rooms);
            }
        }

        Exit exit = new Exit("Exit");
        Shop shop = new Shop("Shop");
        linkRoom(exit, rooms);
        linkRoom(shop, rooms);

        for (Room object : rooms.values()) {
            System.out.println(object.getName());
            System.out.println(object.getPossibleDirections());
        }

        System.out.println(exit.getName());
        System.out.println(exit.getPossibleDirections());
        System.out.println(shop.getName());
        System.out.println(shop.getPossibleDirections());

        return startRoom;
    }

    private void linkRoom(Room room, Map<Integer, Room> rooms) {
        Random rand = new Random();
        Boolean bool = true;
        Room roomToLink;
        int roomToLinkKey = 0;
        while (bool) {
            roomToLinkKey = rand.nextInt(this.nbRoom - 1) + 1;
            roomToLink = rooms.get(roomToLinkKey);
            if (room.getPossibleDirections().size() != 4 || room.getPossibleDirections().size() != 0) {
                bool = false;
            }
        }
        roomToLink = rooms.get(roomToLinkKey);
        bool = true;
        while (bool) {
            Direction direction = Direction.alea();
            if (roomToLink.getNeighbour(direction) == null) {
                roomToLink.addNeighbour(direction, room);
                room.addNeighbour(direction.opposite(), roomToLink);
                bool = false;
            }
        }
    }
}
