package test.java.fil.coo.adventure.places;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Balrog;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.entities.monsters.util.Looter;
import fil.coo.adventure.entities.monsters.util.Orc;
import fil.coo.adventure.entities.monsters.util.Slime;
import fil.coo.adventure.entities.monsters.util.ZombiesHord;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.entity.BalrogRoom;
import fil.coo.adventure.places.entity.GoblinRoom;
import fil.coo.adventure.places.entity.KrakenRoom;
import fil.coo.adventure.places.entity.LooterRoom;
import fil.coo.adventure.places.entity.OrcRoom;
import fil.coo.adventure.places.entity.SlimeRoom;
import fil.coo.adventure.places.entity.ZombieHordRoom;

public class RoomAllTest {

    @Test
    public void balrogRoomTest() {
        Room r = new BalrogRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Balrog)
                isGood = true;
        }

        assertEquals("should be monsters content Balrog", true, isGood);

    }

    @Test
    public void goblinRoomTest() {
        Room r = new GoblinRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Goblin)
                isGood = true;
        }

        assertEquals("should be monsters content Goblin", true, isGood);
    }

    @Test
    public void krakenRoomTest() {
        Room r = new KrakenRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Kraken)
                isGood = true;
        }

        assertEquals("should be monsters content Kraken", true, isGood);
    }

    @Test
    public void looterRoomTest() {
        Room r = new LooterRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Looter)
                isGood = true;
        }

        assertEquals("should be monsters content Looter", true, isGood);
    }

    @Test
    public void orcRoomTest() {
        Room r = new OrcRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Orc)
                isGood = true;
        }

        assertEquals("should be monsters content Orc", true, isGood);
    }

    @Test
    public void slimeRoomTest() {
        Room r = new SlimeRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof Slime)
                isGood = true;
        }

        assertEquals("should be monsters content slime", true, isGood);
    }

    @Test
    public void zombieHordRoomTest() {
        Room r = new ZombieHordRoom();
        boolean isGood = false;
        List<Monster> monsters = r.getMonsters();

        for (Monster m : monsters) {
            if (m instanceof ZombiesHord)
                isGood = true;
        }

        assertEquals("should be monsters content Zombie", true, isGood);
    }
}