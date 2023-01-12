package test.java.fil.coo.adventure.entities.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.util.Loot;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class LootTest {
    @Test
    public void isPossibleToUseLoot() {

        Room r = new Room();
        Loot l = new Loot();
        Monster m = new Goblin();

        assertEquals("should is not posible to use Loot", false, l.isPossible(r));

        r.addDead(m);

        assertEquals("should is posible to use Loot", true, l.isPossible(r));

        r.removeDead(m);

        assertEquals("should is not posible to use Loot", false, l.isPossible(r));

        r.addItem(new LifePotion());

        assertEquals("should is posible to use Loot", true, l.isPossible(r));

        r.addMonster(m);

        assertEquals("should is not posible to use Loot", false, l.isPossible(r));

    }

    @Test
    public void useLoot() {
        Room r = new Room();
        Loot l = new Loot();
        Player p = new Player();
        Monster m = new Goblin();
        LifePotion potion = new LifePotion();
        
        int GoldMonster = m.getGold();
        int initLifePlayer = p.getLifePoints();

        r.addDead(m);
        r.addItem(potion);

        l.execute(r, p);

        assertEquals("check is good translate gold", GoldMonster, p.getGold());

        assertEquals("check use item", true, (initLifePlayer < p.getLifePoints()));
    }
}
