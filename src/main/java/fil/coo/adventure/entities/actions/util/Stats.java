package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Stats implements Actions {
    
    // Is always possible
	public boolean isPossible(Room r) {
		return true;
	}

    // Display player character stats
    public void execute(Room room, Player player) {
        System.out.println("SYS: You currently have " + player.getLifePoints() + " hps.");
        System.out.println("SYS: Your strength is " + player.getStrength() + ".");
        System.out.println("SYS: You currently own " + player.getGold() + " golds.");
    }
}
