package fil.coo.adventure.entities.actions.util;

import java.util.ArrayList;
import java.util.Iterator;
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

	private Room move(Direction d, Room r) {
		r.getNeighbour(d);
		Room room = r.getNeighbour(d);
		return room;
	};

	public boolean isPossible(Room r) {
		List<Monster> monsters = r.getMonsters();
		return (r.getPossibleDirections().size() > 0 && !(monsters.isEmpty()));
	}

	public void execute(Room r, Player p, AdventureGame ag) {

		Room nextRoom = null;

		Set<Direction> directions = r.getPossibleDirections();
		for (Direction direction : directions) {
			System.out.print(direction.toString().toUpperCase() + " /");
		}

		System.out.println(" CANCEL.");

		Scanner scanner = new Scanner(System.in);
		String PlayerDirection = scanner.next();

		switch (PlayerDirection.toLowerCase()) {
			case "north":
			case "n":
				nextRoom = move(Direction.N, r);
				break;

			case "south":
			case "s":
				nextRoom = move(Direction.S, r);
				break;

			case "east":
			case "e":
				nextRoom = move(Direction.E, r);
				break;

			case "west":
			case "w":
				nextRoom = move(Direction.W, r);
				break;

			case "CANCEL":
			case "cancel":

				return;

			default:
				System.out.println("Direction and cancel not found.");
				execute(r, p, ag);
				break;
		}

		if (nextRoom != null) {
			ag.setCurrentRoom(nextRoom);
			return;
		}

		System.out.println("The choice direction is not possible.");
		execute(r, p, ag);
	}

	public void execute(Room r) {

	}

	@Override
	public void execute(Room r, Player p) {
		// TODO Auto-generated method stub

	}
}
