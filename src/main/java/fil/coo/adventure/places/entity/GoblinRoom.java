package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class GoblinRoom extends Room {
    public GoblinRoom() {
        super("Goblin Room");
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
    }
}
