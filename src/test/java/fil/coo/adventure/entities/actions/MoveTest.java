package test.java.fil.coo.adventure.entities.actions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fil.coo.adventure.entities.actions.util.Move;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.directions.Direction;

public class MoveTest {

    @Test
    public void evalutesExpression() {
        Room r = new Room();
        boolean isPossible = new Move().isPossible(r);

        assertEquals("should be is not posible move", false, isPossible);

        r.addNeighbour(Direction.N, new Room());

        isPossible = new Move().isPossible(r);
        assertEquals("should be is posible move", true, isPossible);

    }
}
