package fil.coo.adventure.places;

import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.entities.monsters.util.Orc;

public class OrcRoom extends Room {
    public OrcRoom() {
        super("Orc Room");
        this.addMonster(new Orc());
        this.addMonster(new Goblin());
        this.addMonster(new Goblin());
        this.addItem(new StrengthPotion());
    }
}
