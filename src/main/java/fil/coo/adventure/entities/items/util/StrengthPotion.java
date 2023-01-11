package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {

	@Override
	public void isUsedBy(Player player) {
		player.addStrength(5);
		System.out.println("You drink the found potion.");
		System.out.println("SYS: 5 Strength added to your character.");
	}

}
