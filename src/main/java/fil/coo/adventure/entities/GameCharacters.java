package fil.coo.adventure.entities;

public abstract class GameCharacters {
	protected int LifePoints;
	protected int strength;
	protected int gold;
	
	public GameCharacters() {
		this.LifePoints = 0;
		this.strength = 0;
		this.gold = 0;
	}
	
	public GameCharacters(int lifePoints, int strength) {
		this.LifePoints = lifePoints;
		this.strength = strength;
		this.gold = 0;
	}
	
	public int getLifePoints() {
		return this.LifePoints;
	}
	
	public int getStrength() {
		return this.strength;
	}

	public void addStrength(int strength) {
		this.strength += strength;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void removeGold(int gold) {
		if(!(this.gold - gold < 0)) {
			this.gold -= gold;
		}
	}
	
	public void LooseLife(int strength) {
		this.LifePoints -= strength;
	}

	public void RecoverLife(int number) {
		this.LifePoints += number;
	}
	
	public void attack(GameCharacters theOtherCharacterToAttack) {
		theOtherCharacterToAttack.LooseLife(this.getStrength());
		if (theOtherCharacterToAttack.getLifePoints() >= 0)
			this.LooseLife(theOtherCharacterToAttack.getStrength());
	}

	public String toString() {
		return this.getClass().toString();
	}
}
