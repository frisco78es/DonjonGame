package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Stats implements Actions {
	public boolean isPossible(Room r) {
		return true;
	}

    public void execute(Room r, Player p) {
        System.out.println("SYS: You currently have " + p.getLifePoints() + " hps.");
        System.out.println("SYS: Your strengh is " + p.getStrength() + ".");
        System.out.println("SYS: You currently own " + p.getGold() + " golds.");
    }
}
