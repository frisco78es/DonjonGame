package fil.coo.adventure.places;

import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.util.Kraken;

public class KrakenRoom extends Room{
    public KrakenRoom() {
        super();
        this.addMonster(new Kraken());
        this.addItem(new LifePotion());
        this.addItem(new GoldChest());
    }
}
