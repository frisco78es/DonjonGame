package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.util.Balrog;
import fil.coo.adventure.places.Room;

public class BalrogRoom extends Room {
    public BalrogRoom() {
        super("Balrog Room");
        this.addMonster(new Balrog());
        this.addItem(new StrengthPotion());
    }
}
