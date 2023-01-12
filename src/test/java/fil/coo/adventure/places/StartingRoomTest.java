package test.java.fil.coo.adventure.places;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.entity.StartingRoom;

public class StartingRoomTest {

    @Test
    public void generateRoom() {
        Room r = new StartingRoom();

        assertEquals("check there is no monster in this room", true, r.getMonsters().isEmpty());
        assertEquals("check there is no dead in this room", true, r.getDeads().isEmpty());
        assertEquals("check there is no item in this room", true, r.getItems().isEmpty());
    }
}
