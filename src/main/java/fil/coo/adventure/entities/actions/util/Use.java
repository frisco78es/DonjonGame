package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Use implements Actions {
	public boolean isPossible(Room r) {
		return !r.isExplored();
	}

	public void execute(Room r, Player p) {
		r.interact(p);
	}
}
