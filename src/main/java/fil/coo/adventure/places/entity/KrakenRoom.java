package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.places.Room;

public class KrakenRoom extends Room {
    public KrakenRoom() {
        super("Kraken Room");
        this.addMonster(new Kraken());
        this.addItem(new LifePotion());
        this.addItem(new GoldChest());
    }
}
