package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.monsters.util.Looter;
import fil.coo.adventure.places.Room;

public class LooterRoom extends Room {
    public LooterRoom () {
        super("Looter Room");
        this.addMonster(new Looter());
        this.addMonster(new Looter());
        this.addMonster(new Looter());
        this.addItem(new GoldChest());
    }

    public void interact(Player player) {
        this.explored = true;
        player.addGold(50);
        System.out.println("Lucky you ! You just found some gold in a crate, 50 more in your pocket !");
    }
}
