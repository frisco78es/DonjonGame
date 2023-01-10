package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.places.Room;

import java.util.List;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.monsters.*;
import fil.coo.adventure.entities.actions.Actions;

public class Look implements Actions {

	@Override
	public void execute(Room r) {
		List<Monster> monsters = r.getMonsters();
		List<Item> items = r.getItems();
		List<GameCharacters> characters = r.getDeads();

		System.out.println("you are hunter in the " + r.name);
		System.out.println("you saw in the room several " + monsters.size() + " x "
				+ monsters.get(0).getClass().getName() + " ready to fight");

		for (Monster m : monsters) {
			System.out.println(m.toString());
		}

		System.out.println("you appear tappis in the mist his items");

		for (Item item : items) {
			System.out.println(item.toString());
		}

		if (characters.size() > 0) {
			System.out.println("there are corpses gnawing on the ground");
			for (GameCharacters g : characters) {
				System.out.println(g.toString());
			}
		}

	}

	public boolean isPossible(Room r) {
		return true;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
}
