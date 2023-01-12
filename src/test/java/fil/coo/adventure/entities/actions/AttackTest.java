package test.java.fil.coo.adventure.entities.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.util.Attack;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class AttackTest {

    @Test
    public void isPossibleToUse() {
        Room r = new Room();
        Attack a = new Attack();

        assertEquals("should be is not possible to use attack", a.isPossible(r), false);

        r.addMonster(new Goblin());

        assertEquals("should be is possible to use attack", a.isPossible(r), true);
    }

    @Test
    public void UseAttack() {
        Room r = new Room();
        Player p = new Player();
        Attack a = new Attack();
        r.addMonster(new Goblin());
        a.execute(r, p);

        assertEquals("should execute attack is check the loser is deplace in the deads tabs", r.getDeads().size(), 1);
    }
}
