package test.java.fil.coo.adventure.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Goblin;

public class PlayerTest {
    private Player p;

    @Before
    public void setup() {
        this.p = new Player();
    }

    @Test
    public void GoldTest() {
        assertEquals("player start 0", 0, p.getGold());

        this.p.addGold(5);

        assertEquals("player add 5 gold", 5, p.getGold());

        this.p.removeGold(3);

        assertEquals("player loose 3 gold", 2, p.getGold());
    }

    @Test
    public void LifeTest() {
        int initLife = this.p.getLifePoints();

        assertEquals("player start 0", initLife, this.p.getLifePoints());

        this.p.RecoverLife(5);

        assertEquals("player add 5 gold", initLife + 5, this.p.getLifePoints());

        this.p.LooseLife(5);

        assertEquals("player loose 5 point life", initLife, this.p.getLifePoints());
    }

    @Test
    public void AttackTest() {
        Monster m = new Goblin();
        int initLife = this.p.getLifePoints();
        int initMobLife = m.getLifePoints();

        assertEquals("check init life player", initLife, this.p.getLifePoints());
        assertEquals("check init life monster", initMobLife, m.getLifePoints());

        this.p.attack(m);

        assertEquals("player life down for mod dommage", initLife - m.getStrength(), this.p.getLifePoints());
        assertEquals("player life down for mod dommage", initMobLife - this.p.getStrength(), m.getLifePoints());

    }

}
