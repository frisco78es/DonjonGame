package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Move implements Actions {
	public boolean isPossible(Room r) {
		return (r.getPossibleDirections().size() > 0);
	}

	@Override
	public void execute(Room r, Player p) {
		// TODO Auto-generated method stub

	}

	public void execute(Room r) {

	}
}
