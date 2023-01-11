package fil.coo.adventure.entities.actions.util;

import java.util.List;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.Room;

public class Loot implements Actions {

	public void execute(Room r, Player p) {
		
		List<GameCharacters> characters = r.getDeads();
		List<Item> items = r.getItems();
		
		for(GameCharacters gc : characters){
			p.addGold(gc.getGold());
			r.removeDead(gc);
			System.out.println("While looking for some drops on this " + gc.toString() + " you were able to find " + gc.getGold() + "golds.");
		}
		for(Item i : items){
			System.out.println("While looking onto the ground, you were also able to find a " + i.toString());
			i.isUsedBy(p);
			r.removeItem(i);
		}
	}
	
	public boolean isPossible(Room r) {
		return !r.getDeads().isEmpty();
	}
} 