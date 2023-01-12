package test.java.fil.coo.adventure.entities.actions;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.adventure.entities.actions.util.Move;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.directions.Direction;

public class MoveTest {

    @Test
    public void isPossibleToUse() {
        Room r = new Room();
        boolean isPossible = new Move().isPossible(r);

        assertEquals("should be is not posible move", false, isPossible);

        r.addNeighbour(Direction.N, new Room());

        isPossible = new Move().isPossible(r);
        assertEquals("should be is posible move", true, isPossible);
    }

    @Test
    public void useMove() {
        Room currentRoom = new Room();
        Room nextRoom = new Room();
        Move move = new Move();

        currentRoom.addNeighbour(Direction.N, nextRoom);
        nextRoom.addNeighbour(Direction.S, currentRoom);

        assertEquals("should be check move return the next room", move.move(Direction.N, currentRoom), nextRoom);

        assertEquals("should be check move return the old room", move.move(Direction.S, nextRoom), currentRoom);

    }
}
