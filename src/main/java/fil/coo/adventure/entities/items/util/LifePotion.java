package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {
	private final int value = 30;

	@Override
	public void isUsedBy(Player player) {
		player.RecoverLife(this.value);
		System.out.println("You drink the found potion.");
		System.out.println("SYS: 30 life points recovered.");
	}

	@Override
	public String toString() {
		return "Life Potion";
	}

	public int getValue() {
		return this.value;
	}
}
