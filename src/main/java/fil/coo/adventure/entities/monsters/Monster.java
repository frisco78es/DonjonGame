package fil.coo.adventure.entities.monsters;

import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;

public abstract class Monster extends GameCharacters {
	public Monster(int lifePoints, int strength) {
		super(lifePoints, strength);

		// Add a random gold amont on each mob between 5 and 20
		Random rand = new Random();
		this.gold = rand.nextInt(15) + 5;
	}
}
