package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.monsters.Monster;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;

public class Attack implements Actions {

	private boolean fight(Player p, GameCharacters gc) {
		while (p.getLifePoints() > 0 && gc.getLifePoints() > 0) {
			p.attack(gc);
		}
		
		if (p.getLifePoints() <= 0) {
			return false;
		}

		return true;
	}

	public void execute(Room r, Player p) {

		while (r.getMonsters().size() > 0) {
			Monster m = r.getFirstMonster();
			boolean isWin = this.fight(p, m);

			if (isWin) {
				r.addDead(m);
				r.removeMonster(m);
			} else {
				r.addDead(p);
			}
		}
	}

	public boolean isPossible(Room r) {
		return !r.getMonsters().isEmpty();
	}
}
