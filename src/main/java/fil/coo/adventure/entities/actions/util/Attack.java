package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.Player;

import java.util.List;

public class Attack implements Actions {

	public void execute(Room r, Player p) {
		List<Monster> monsters = r.getMonsters();
		for (Monster monster : monsters) {
			do {
				p.attack(monster);
			} while (!(monster.getLifePoints() <= 0 || p.getLifePoints() <= 0));
			if (monster.getLifePoints() <= 0) {
				r.removeMonster(monster);
				r.addDead(monster);
			}
		}
	}

	public boolean isPossible(Room r) {
		return !r.getMonsters().isEmpty();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Room r) {
		// TODO Auto-generated method stub

	}
}
