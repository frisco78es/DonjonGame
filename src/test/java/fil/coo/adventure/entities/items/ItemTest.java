package test.java.fil.coo.adventure.entities.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.items.util.TrappedChest;

public class ItemTest {

    @Test
    public void useGoldChest() {
        Player p = new Player();
        Item goldChest = new GoldChest();

        goldChest.isUsedBy(p);

        assertEquals("chack player riseve gold", goldChest.getValue(), p.getGold());
    }

    @Test
    public void useLifePotion() {
        Player p = new Player();
        Item i = new LifePotion();
        int initLife = p.getLifePoints();

        i.isUsedBy(p);

        assertEquals("chack player riseve gold", initLife + i.getValue(), p.getLifePoints());
    }

    @Test
    public void useStrengthPotion() {
        Player p = new Player();
        Item i = new StrengthPotion();
        int initStrength = p.getStrength();

        i.isUsedBy(p);

        assertEquals("chack player riseve gold", initStrength + i.getValue(), p.getStrength());
    }

    @Test
    public void useTrapped() {
        Player p = new Player();
        Item i = new TrappedChest();
        int initLife = p.getLifePoints();

        i.isUsedBy(p);

        assertEquals("chack player riseve gold", initLife - i.getValue(), p.getLifePoints());
    }

}
