package fil.coo.adventure;

import java.util.Scanner;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.entities.actions.util.Attack;
import fil.coo.adventure.entities.actions.util.Look;
import fil.coo.adventure.entities.actions.util.Loot;
import fil.coo.adventure.entities.actions.util.Move;
import fil.coo.adventure.entities.actions.util.Use;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.*;
import fil.coo.adventure.places.directions.*;
import fil.coo.adventure.entities.monsters.*;

public class AdventureGame {
	private Room currentRoom;
	private Player player;

	public AdventureGame() {
		this.player = new Player();
	}

	public Room currentRoom() {
		return this.currentRoom;
	}

	public void setCurrentRoom(Room room) {
		this.currentRoom = room;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
	}

	public void addItem(Item item, Room room) {
		room.addItem(item);
	}

	public boolean isFinished() {
		return this.currentRoom.isExit() && this.currentRoom.getMonsters().isEmpty();
	}

	public void playerMoveTo(Direction direction) {
		this.currentRoom = this.currentRoom.getNeighbour(direction);
	}

	public void start() {
		System.out.println("The new game starts");
		System.out.println(
				"You are an adventurer who try too cross a dongeon. Your objectif is to find the exit and beat the Dragon that guard it. Good luck and may the god be with you !");
		System.out.println(
				"Welcome to the first room of the dungeon. Here's a little tutorial on how it work. At the start of each turn, you will be able to choose an action. This action will dictate what happen. Try using the action USE to start out.");
		Scanner scan = new Scanner(System.in);
		while (!this.isFinished() && !(this.player.getLifePoints() <= 0)) {
			String action;
			System.out.println("What do you do ?");
			System.out.println("ATTACK / LOOK / LOOT / MOVE / USE ?");
			action = scan.next();
			switch (action.toLowerCase()) {
				case "attack":
					Attack attack = new Attack();
					if (attack.isPossible(this.currentRoom) == false) {
						System.out.println("There aren't any monsters. You can't do this action");
						break;
					}
					attack.execute(currentRoom, player);
					break;
				case "look":
					Look look = new Look();
					if (look.isPossible(this.currentRoom) == false) {
						System.out.println(
								"There aren't any monsters, any dead bodies and any items. You can't do this action");
						break;
					}
					look.execute(currentRoom);
					break;
				case "use":
					Use use = new Use();
					if (use.isPossible(this.currentRoom) == false) {
						System.out.println("This room have already been interacted with. You can't do this action");
						break;
					}
					use.execute(currentRoom, player);
					break;
				case "move":
					Move move = new Move();
					if (move.isPossible(this.currentRoom) == false) {
						System.out.println("You can't currently move.");
						break;
					}
					move.execute(this.currentRoom, player, this);
					break;
				case "loot":
					Loot loot = new Loot();
					if (loot.isPossible(this.currentRoom) == false) {
						System.out.println("There aren't any dead body in this place. You can't do this action");
						break;
					}
					loot.execute(currentRoom, player);
					break;
				default:
					System.out.println("You're action isn't in the list");
					break;
			}
		}
		if (this.player.getLifePoints() <= 0) {
			System.out.println("You just died in the dungeon, thanks for playing and good luck next time.");
		}
		if (this.isFinished()) {
			System.out.println(
					"Congratulations ! You did beat the dungeon. But many secrets still remain in the dungeon, and you are welcome to try it again !");
		}
		scan.close();
	}
}
