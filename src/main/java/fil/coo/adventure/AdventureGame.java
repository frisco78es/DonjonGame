package fil.coo.adventure;

import java.util.Scanner;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.entities.actions.util.Attack;
import fil.coo.adventure.entities.actions.util.Look;
import fil.coo.adventure.entities.actions.util.Loot;
import fil.coo.adventure.entities.actions.util.Move;
import fil.coo.adventure.entities.actions.util.Stats;
import fil.coo.adventure.entities.actions.util.Interact;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.*;
import fil.coo.adventure.places.directions.*;
import fil.coo.adventure.entities.monsters.*;

public class AdventureGame {
	private Room currentRoom;
	private Player player;
	private int level;

	public AdventureGame() {
		this.player = new Player();
		this.level = 1;

		Donjon map = new Donjon(this.level * 5);
		Room startingRoom = map.generateMap();
		this.setCurrentRoom(startingRoom);
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
		return this.currentRoom.isExit() && this.currentRoom.getMonsters().isEmpty() && this.currentRoom.isExplored();
	}

	public void playerMoveTo(Direction direction) {
		this.currentRoom = this.currentRoom.getNeighbour(direction);
	}

	public void start() {
		System.out.println("The new game starts");
		System.out.println(
				"You are an adventurer who try to cross a dongeon. Your objectif is to find the exit and beat the Dragon that guard it. Good luck and may the god be with you !");
		System.out.println(
				"Welcome to the first room of the dungeon. Here's a little tutorial on how it works. At the start of each turn, you will be able to choose an action. This action will dictate what happen. Try using the action INTERACT to start out.");
		Scanner scanner = new Scanner(System.in);

		// Game loop continue until your life point reach 0 or you beat level 6
		while (this.level < 6 && !(this.player.getLifePoints() <= 0)) {
			String action;
			System.out.println("What do you want to do ?");
			System.out.println("ATTACK / LOOK / LOOT / MOVE / INTERACT / STATS ?");
			action = scanner.next();
			switch (action.toLowerCase()) {
				case "attack":
					Attack attack = new Attack();
					if (attack.isPossible(this.currentRoom) == false) {
						System.out.println("There aren't any monsters. You can't do this action");
						break;
					}
					attack.execute(this.currentRoom, this.player);
					break;
				case "look":
					Look look = new Look();
					if (look.isPossible(this.currentRoom) == false) {
						System.out.println(
								"There aren't any monsters, any dead bodies and any items. You can't do this action");
						break;
					}
					look.execute(this.currentRoom);
					break;
				case "interact":
					Interact use = new Interact();
					if (use.isPossible(this.currentRoom) == false) {
						System.out.println("This room have already been interacted with. You can't do this action");
						break;
					}
					use.execute(this.currentRoom, this.player);
					break;
				case "move":
					Move move = new Move();
					if (move.isPossible(this.currentRoom) == false) {
						System.out.println("You can't currently move.");
						break;
					}
					move.execute(this.currentRoom, this.player, this);
					break;
				case "loot":
					Loot loot = new Loot();
					if (loot.isPossible(this.currentRoom) == false) {
						System.out.println("There aren't any dead body in this place. You can't do this action");
						break;
					}
					loot.execute(this.currentRoom, this.player);
					break;
				case "stats":
					Stats stats = new Stats();
					if (stats.isPossible(this.currentRoom) == false) {
						System.out.println("You can't consult your stat.");
						break;
					}
					stats.execute(this.currentRoom, this.player);
					break;
				default:
					System.out.println("Your action isn't in the list");
					break;
			}
			if (this.isFinished()) {
				System.out.println("Congratulations ! You did beat the level. But the dungeon don't end yet !");
				this.level += 1;
				System.out.println("You now enter the level " + this.level + " !");
				Donjon map = new Donjon(this.level * 5);
				Room startingRoom = map.generateMap();
				this.setCurrentRoom(startingRoom);
			}
		}
		if (this.player.getLifePoints() <= 0) {
			System.out.println("You just died in the dungeon, thanks for playing and good luck for the next time.");
		}

		if (this.level > 5) {
			System.out.println(
					"The 6th level brings you at the roof of the dungeon. You found a huge portal that you can't seem to interact with yet. You should go back to the cattle and give your report to the king.");
			System.out.println("Thanks for playing !");
		}
		scanner.close();
	}
}
