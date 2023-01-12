package fil.coo.adventure.entities.actions.util;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.actions.Actions;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.directions.Direction;

public class Move implements Actions {
	private Scanner scanner;

	public Move() {
		this.scanner = new Scanner(System.in);
	}

	public Room move(Direction d, Room r) {
		r.getNeighbour(d);
		return r.getNeighbour(d);
	};

	public boolean isPossible(Room room) {
		// Action is only possible if 
		List<Monster> monsters = room.getMonsters();
		return (room.getPossibleDirections().size() > 0 && monsters.isEmpty());
	}

	public void execute(Room room, Player player, AdventureGame game) {

		Room nextRoom = null;

		Set<Direction> directions = room.getPossibleDirections();
		// Display all possible direction to take for the user.
		for (Direction direction : directions) {
			System.out.print(direction.toString().toUpperCase() + " / ");
		}
		System.out.println("CANCEL ?");

		String PlayerDirection = this.scanner.next();

		// Associate a room for each direction.
		switch (PlayerDirection.toLowerCase()) {
			case "north":
			case "n":
				nextRoom = move(Direction.N, room);
				break;

			case "south":
			case "s":
				nextRoom = move(Direction.S, room);
				break;

			case "east":
			case "e":
				nextRoom = move(Direction.E, room);
				break;

			case "west":
			case "w":
				nextRoom = move(Direction.W, room);
				break;

			case "CANCEL":
			case "cancel":
				return;
			default:
				System.out.println("Direction given is not valid.");
				this.execute(room, player, game);
				break;
		}

		// If a room exist, move to the next room and return
		if (nextRoom != null) {
			game.setCurrentRoom(nextRoom);
			System.out.println("You are moving to the " + PlayerDirection.toLowerCase() + ".");
			System.out.println("After a long corridor, you finaly enter a room with written " + nextRoom.getName()
					+ " at the entrance.");
			return;
		} else {
		// If not, reask for a direction
		System.out.println("The choiced direction is lead to nothing.");
		this.execute(room, player, game);
		}
	}

	public void execute(Room room) {}

	@Override
	public void execute(Room room, Player player) {}
}
