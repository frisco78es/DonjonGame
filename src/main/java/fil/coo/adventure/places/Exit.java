package fil.coo.adventure.places;

import fil.coo.adventure.entities.monsters.util.*;

public class Exit extends Room {
	public Exit() {
		super("Exit Room");
	}

	public Exit(String name) {
		super(name);
	}
	
	public boolean isExit() {
		return true;
	}

	public void interact() {
		this.explored = true;
		this.monsters.add(new Dragon());
		System.out.println("A fierce dragon spawn to prevent you to reach the door. Beat it before you can complete the level.");
	}
}
