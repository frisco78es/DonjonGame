package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.monsters.util.ZombiesHord;
import fil.coo.adventure.places.Room;

public class ZombieHordRoom extends Room {
    public ZombieHordRoom() {
        this.addMonster(new ZombiesHord());
        this.addMonster(new ZombiesHord());
        this.addMonster(new ZombiesHord());
    }
}
