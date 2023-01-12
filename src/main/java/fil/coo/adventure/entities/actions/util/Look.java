package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.places.Room;

import java.util.List;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.monsters.*;
import fil.coo.adventure.entities.actions.Actions;

public class Look implements Actions {

	public void execute(Room r) {
		List<Monster> monsters = r.getMonsters();
		List<Item> items = r.getItems();
		List<GameCharacters> characters = r.getDeads();

		System.out.println("You are currently in " + r.name);
		System.out.println("In the dark of the room you can see " + monsters.size() + " monsters ready to fight");

		for (Monster m : monsters) {
			System.out.println(m.toString());
		}

		if(items.size() > 0) {
			System.out.println("While looking around, you also spot some item on the ground that are ready to be taken.");
		}

		for (Item item : items) {
			System.out.println(item.toString());
		}

		if (characters.size() > 0) {
			System.out.println("You can also see some corpses gnawing on the ground");
			for (GameCharacters g : characters) {
				System.out.println(g.toString());
			}
		}
	}

	public boolean isPossible(Room r) {
		return true;
	}

	@Override
	public void execute(Room r, Player p) {
		this.execute(r);
	}
}
