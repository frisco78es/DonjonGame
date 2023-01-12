package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.Room;

public class Loot implements Actions {

	public void execute(Room r, Player p) {
		while (r.getDeads().size() > 0) {
			GameCharacters corpse = r.getFirstDead();
			p.addGold(corpse.getGold());
			r.removeDead(corpse);
			System.out.println("While looking for some drops on this " + corpse.toString() + " you were able to find "
					+ corpse.getGold() + "golds.");
		}

		while (r.getItems().size() > 0) {
			Item item = r.getFirstItem();
			System.out.println("While looking onto the ground, you were also able to find a " + item.toString());
			item.isUsedBy(p);
			r.removeItem(item);
		}
	}

	public boolean isPossible(Room r) {
		return !r.getDeads().isEmpty();
	}
}