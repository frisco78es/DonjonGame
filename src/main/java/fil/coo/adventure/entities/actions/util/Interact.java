package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Interact implements Actions {
	// is possible if the room haven't been explored
	public boolean isPossible(Room room) {
		return !room.isExplored();
	}

	public void execute(Room room, Player player) {
		room.interact(player);
	}
}
