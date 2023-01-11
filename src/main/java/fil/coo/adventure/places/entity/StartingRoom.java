package fil.coo.adventure.places.entity;

import fil.coo.adventure.places.Room;

public class StartingRoom extends Room {
    public StartingRoom(String name) {
        super(name);
    }

    public StartingRoom() {
        super("Starting Room");
    }

    public boolean isStart() {
        return true;
    }
}
