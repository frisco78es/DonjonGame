package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {
	private final int value = 5;

	@Override
	public void isUsedBy(Player player) {
		player.addStrength(this.value);
		System.out.println("You drink the found potion.");
		System.out.println("SYS: 5 Strength added to your character.");
	}

	@Override
	public String toString() {
		return "Strength Potion";
	}

	public int getValue() {
		return this.value;
	}
}
