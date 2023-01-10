package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fil.coo.adventure.places.directions.Direction;

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
            rooms.put(i, lastObject);
        }
        for (Room object : rooms.values()) {
            System.out.println(object.getClass());
        }

        int nbAl = rand.nextInt(4) + 1;
        StartingRoom startRoom = new StartingRoom();
        List<Room> roomUsed = new ArrayList<Room>();
        while (nbAl != 0) {
            Direction direction = Direction.alea();
            if (startRoom.getNeighbour(direction) == null) {
                for (Room room : rooms.values()) {
                    if (room.getNeighbour(direction) == null) {
                        startRoom.addNeighbour(direction, room);
                        room.addNeighbour(direction.opposite(), startRoom);
                        roomUsed.add(room);
                    }
                }
            }
            nbAl--;
        }
        for (Room room : roomUsed) {
            int nbAléa = rand.nextInt(4 - room.getPossibleDirections().size()) + 1;
            while (nbAléa != 0) {
                for (Room room2 : rooms.values()) {
                    if (room2.getPossibleDirections().size() != 0) {
                        continue;
                    }
                    Direction direction = Direction.alea();
                    if (room.getNeighbour(direction) == null) {
                        if (room2.getNeighbour(direction) == null) {
                            room.addNeighbour(direction, room2);
                            room2.addNeighbour(direction.opposite(), room);
                            roomUsed.add(room2);
                        }
                    }
                }
                nbAléa--;
            }
        }

        Exit exit = new Exit();
        Shop shop = new Shop();
        Boolean bool = true;
        while (bool) {
            int exitRoom = rand.nextInt(this.nbRoom - 1) + 1;
            Room room = rooms.get(exitRoom);
            if (room.getPossibleDirections().size() == 4) {
                continue;
            }
            while (exit.getPossibleDirections().size() != 0) {
                Direction direction = Direction.alea();
                if (room.getNeighbour(direction) == null) {
                    room.addNeighbour(direction, exit);
                    exit.addNeighbour(direction.opposite(), room);
                }
            }
        }
        while (bool) {
            int shopRoom = rand.nextInt(this.nbRoom - 1) + 1;
            Room room = rooms.get(shopRoom);
            while (shop.getPossibleDirections().size() != 0) {
                Direction direction = Direction.alea();
                if (room.getNeighbour(direction) == null) {
                    room.addNeighbour(direction, shop);
                    shop.addNeighbour(direction.opposite(), room);
                }
            }
        }
        for (Room object : rooms.values()) {

            System.out.println(object.getPossibleDirections());
        }
        System.out.println(startRoom.getPossibleDirections());
        System.out.println(exit.getPossibleDirections());
        System.out.println(shop.getPossibleDirections());
        return startRoom;
    }

}