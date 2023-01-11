package fil.coo.adventure;

import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.Donjon;

public class Main {

	public static void main(String[] args) {
		AdventureGame aG = new AdventureGame();
		Donjon map = new Donjon(5);
		Room startingRoom = map.generateMap();
		aG.setCurrentRoom(startingRoom);
		aG.start();
	}
}
