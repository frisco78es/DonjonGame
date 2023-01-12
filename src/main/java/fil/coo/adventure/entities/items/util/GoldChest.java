package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {
	private final int value = 50;

	@Override
	public void isUsedBy(Player player) {
		System.out.println(
				"Lucky you, the chest is already openned, you take everything inside worth something and leave.");
		System.out.println("SYS: 50 golds added to your bag.");
		player.addGold(this.value);
	}

	@Override
	public String toString() {
		return "Gold Chest";
	}

	public int getValue() {
		return this.value;
	}
}
