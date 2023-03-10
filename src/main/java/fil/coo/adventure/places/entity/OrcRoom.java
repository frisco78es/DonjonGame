package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.entities.monsters.util.Orc;
import fil.coo.adventure.places.Room;

public class OrcRoom extends Room {
    public OrcRoom() {
        super("Orc Room");
        this.addMonster(new Orc());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addItem(new StrengthPotion());
    }
}
