package test.java.fil.coo.adventure.entities.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.util.Interact;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.entity.TrappedRoom;

public class InteractTest {

    @Test
    public void isPossibleToUseUse() {
        Room r = new Room();
        Interact i = new Interact();

        assertEquals("should is posible to use room", true, i.isPossible(r));

        r.interact(new Player());

        assertEquals("should is not possible to second use Use", false, i.isPossible(r));
    }

    @Test
    public void useUse() {
        Room r = new TrappedRoom();
        Player p = new Player();
        Interact i = new Interact();

        assertEquals("should be nombre of monstre is zero", 0, r.getMonsters().size());

        i.execute(r, p);

        assertEquals("should use use in the room and monsters is equal 2", 2, r.getMonsters().size());
    }

}
