package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {

	@Override
	public void isUsedBy(Player player) {
		player.RecoverLife(30);
		System.out.println("You drink the found potion.");
		System.out.println("SYS: 30 life points recovered.");
	}

}
