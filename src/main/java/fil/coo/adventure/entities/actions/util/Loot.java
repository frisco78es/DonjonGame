package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.Room;

public class Loot implements Actions {

	public void execute(Room room, Player player) {
		while (room.getDeads().size() > 0) {
			GameCharacters corpse = room.getFirstDead();
			player.addGold(corpse.getGold());
			room.removeDead(corpse);
			System.out.println("While looking for some drops on this " + corpse.toString() + " corpse, you were able to find "
					+ corpse.getGold() + "golds.");
		}

		while (room.getItems().size() > 0) {
			Item item = room.getFirstItem();
			System.out.println("While looking onto the ground, you were also able to find a " + item.toString());
			item.isUsedBy(player);
			room.removeItem(item);
		}
	}

	public boolean isPossible(Room room) {
		// Action is only possible if the room have no monsters alive
		return room.getMonsters().isEmpty();
	}
}
