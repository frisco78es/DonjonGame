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
	
	public void play(Player player) {
		while(!this.isFinished()) {
			
		}
	}
	
	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
	}
	
	public void addItem(Item item, Room room) {
		room.addItem(item);
	}
	
	public boolean isFinished() {
		return this.player.getLifePoints() > 0 && this.currentRoom.isExit() && this.currentRoom.getMonsters().isEmpty();
	}
	
	public void playerMoveTo(Direction direction) {
		this.currentRoom = this.currentRoom.getNeighbour(direction);
	}

	public void start() {
		String action;
		Boolean boolAction = false;
		Look look = new Look();
		Attack attack = new Attack();
		Loot loot = new Loot();
		Use use = new Use();
		Move move = new Move();
		Scanner scan = new Scanner(System.in);
		System.out.println("The new game starts");
		if(this.currentRoom.isStart()) {
			while(boolAction == false) {
				System.out.println("What do you do ?");
				System.out.println("ATTACK / LOOK / LOOT / MOVE / USE ?");
				action = scan.next();
				switch(action.toLowerCase()) {
					case "attack":
						if(attack.isPossible(this.currentRoom) == false) {
							System.out.println("There aren't any monsters. You can't do this action");
							boolAction = false;
						}
						break;
					case "look":
						if(look.isPossible(this.currentRoom) == false) {
							System.out.println("There aren't any monsters, any dead bodies and any items. You can't do this action");
						}
						break;
					case "use":
						use.isPossible(this.currentRoom);
						if(use.isPossible(this.currentRoom) == false) {
							System.out.println("You don't have any objects. You can't do this action");
						}
						break;
					case "move":
						if(move.isPossible(this.currentRoom) == true) {
							System.out.println("en attente");
							boolAction = true;
							scan.close();
						}
						break;
					case "loot":
						if(loot.isPossible(this.currentRoom) == false) {
							System.out.println("There aren't any dead body in this place. You can't do this action");
						}
						break;
					default:
						System.out.println("You're action isn't in the list");
						break;
				}
			}
		}
	}
}
