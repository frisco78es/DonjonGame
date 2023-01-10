package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.places.Room;

public class GoblinRoom extends Room {

    public final static String name = "GoblinRoom";

    public GoblinRoom() {
        super();
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addItem(new LifePotion());
    }
}
