package fil.coo.adventure.places;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.monsters.util.Looter;

public class LooterRoom extends Room {
    public LooterRoom () {
        super("Looter Room");
        this.addMonster(new Looter());
        this.addMonster(new Looter());
        this.addMonster(new Looter());
        this.addItem(new GoldChest());
    }

    public void interact(Player player) {
        player.addGold(50);
        System.out.println("Lucky you ! You just some gold in a crate, 50 more in your pocket !");
    }
}
