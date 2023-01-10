package fil.coo.adventure.places;

import fil.coo.adventure.entities.monsters.util.*;

public class Exit extends Room {
	public Exit() {
		super();
		this.monsters.add(new Dragon());
	}

	public Exit(String name) {
		super(name);
		this.monsters.add(new Dragon());
	}
	
	public boolean isExit() {
		return true;
	}
}
