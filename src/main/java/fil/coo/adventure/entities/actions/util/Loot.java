package fil.coo.adventure.entities.actions.util;

import java.util.List;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.places.Room;

public class Loot implements Actions {

	public void execute(Room r, Player p) {
		
		List<GameCharacters> characters = r.getDeads();
		
		for(GameCharacters gc : characters){
			p.addGold(gc.getGold());
			r.removeDead(gc);
			System.out.println("Vous avez gagné" + gc.getGold() + "gold, Bravo !");
		}

	}
	
	public boolean isPossible(Room r) {
		return !r.getDeads().isEmpty();
	}
} 