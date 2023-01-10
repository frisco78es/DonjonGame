package fil.coo.adventure;

import fil.coo.adventure.AdventureGame;
import fil.coo.adventure.places.Room;
import fil.coo.adventure.places.Donjon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdventureGame aG = new AdventureGame(); //Méthode generateMap à compléter
		Donjon map = new Donjon(5);
		Room startingRoom = map.generateMap();
		aG.setCurrentRoom(startingRoom);
		//aG.start();
	}
}
