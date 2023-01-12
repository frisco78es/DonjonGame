package fil.coo.adventure.entities.items;

import fil.coo.adventure.entities.Player;

public abstract class Item {

	public abstract void isUsedBy(Player player);

	public abstract String toString();

	public abstract int getValue();
}
