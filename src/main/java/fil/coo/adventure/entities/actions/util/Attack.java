package fil.coo.adventure.entities.actions.util;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.monsters.Monster;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;

public class Attack implements Actions {

	private boolean fight(Player player, GameCharacters gameCharacter) {
		// fight continue until one of the character is dead
		while (player.getLifePoints() > 0 && gameCharacter.getLifePoints() > 0) {
			player.attack(gameCharacter);
		}
		
		if (player.getLifePoints() <= 0) {
			return false;
		}

		return true;
	}

	public void execute(Room room, Player player) {
		// fight monsters in the room until everyone of them is defeated or you die
		while (room.getMonsters().size() > 0 && player.getLifePoints() > 0) {
			Monster monster = room.getFirstMonster();
			boolean isWin = this.fight(player, monster);

			if (isWin) {
				room.addDead(monster);
				room.removeMonster(monster);
			} else {
				room.addDead(player);
			}
		}
	}

	public boolean isPossible(Room room) {
		// Action is only possible if the room have monsters alive
		return !room.getMonsters().isEmpty();
	}
}
