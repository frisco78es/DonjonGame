package fil.coo.adventure.places;

import fil.coo.adventure.entities.Player;

public class Shop extends Room {
	public Shop(String name) {
		super(name);
	}

	public Shop() {
		super("Shop");
	}

	public void interact(Player player) {
		this.explored = true;
		System.out.println(
				"You found a not very welcoming shop offering you to buy some items in exchange of your precious gold.");
		System.out.println("You can either enter the shop or leave. What would you do ?");
		Boolean stay = true;
		while (stay) {
			System.out.println("ENTER / LEAVE ?");
			String playerAnswer = this.scanner.nextLine();
			switch (playerAnswer.toLowerCase()) {
				case "enter":
					this.shop(player);
					break;
				case "leave":
					System.out.println("You're are leaving this place.");
					stay = false;
					return;
				default:
					System.out.println("SYS: You entered a wrong command, please try again.");
					break;
			}
		}
	}

	private void shop(Player player) {
		System.out.println(
				"You decide to enter the shop and are welcome by a small goblin, welcoming you to look at his items.");
		System.out.println("You find some healing potions, being trade for 30 golds.");
		System.out.println("You find some stength potions, being trade for 50 golds.");
		System.out.println("What would you do ?");
		Boolean stay = true;
		while (stay) {
			System.out.println("Current gold amount: " + player.getGold() + "g");
			System.out.println("HEAL / STRENGTH / LEAVE ?");
			String playerAnswer = this.scanner.nextLine();
			switch (playerAnswer.toLowerCase()) {
				case "heal":
					if (player.getGold() > 30) {
						System.out.println("Thanks for buying a healing potion !");
						System.out.println("SYS: 30 life points recovered.");
						player.removeGold(30);
						player.RecoverLife(30);
					} else {
						System.out.println("You don't have enough gold for that");
					}
					break;
				case "strength":
					if (player.getGold() > 50) {
						System.out.println("Thanks for buying a strength potion !");
						System.out.println("SYS: 5 Strength added to your character.");
						player.removeGold(50);
						player.addStrength(5);
					} else {
						System.out.println("You don't have enough gold for that");
					}
					break;
				case "leave":
					System.out.println("See you next time !");
					stay = false;
					return;
				default:
					System.out.println("SYS: You entered a wrong command, please try again.");
					break;
			}
		}
	}
}
