package fil.coo.adventure.places;

import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.util.Goblin;

public class GoblinRoom extends Room {
    public GoblinRoom() {
        super("Goblin Room");
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
    }
}
