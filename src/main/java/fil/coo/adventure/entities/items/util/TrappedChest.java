package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class TrappedChest extends Item {
	private final int value = 10;

	@Override
	public void isUsedBy(Player player) {
		player.LooseLife(this.value);
		System.out.println(
				"You see a small chest in the corner of the room, hyped by your discovery, you rush over it to open it. Unfortunaly, this chest was a trapped one ! It attack you as soon as you get in range. Fortunaly it have a really hard time moving around and you beat it without any problem.");
		System.out.println("SYS: 10 life points removed.");
	}

	@Override
	public String toString() {
		return "Gold Chest";
	}

	public int getValue() {
		return this.value;
	}
}
