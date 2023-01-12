package fil.coo.adventure.places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.places.directions.Direction;

public class Room {
	protected List<Monster> monsters;
	protected List<GameCharacters> deads;
	protected List<Item> items;
	protected Map<Direction, Room> neighbour;
	public String name;
	public Boolean explored = false;
	protected Scanner scanner;

	public Room() {
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.deads = new ArrayList<GameCharacters>();
		this.neighbour = new HashMap<Direction, Room>();
		this.name = "";
		this.scanner = new Scanner(System.in);
	}

	public Room(String name) {
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.deads = new ArrayList<GameCharacters>();
		this.neighbour = new HashMap<Direction, Room>();
		this.name = name;
		this.scanner = new Scanner(System.in);
	}

	public void addMonster(Monster monster) {
		this.monsters.add(monster);
	}

	public void removeMonster(Monster monster) {
		this.monsters.remove(monster);
	}

	public List<Monster> getMonsters() {
		return this.monsters;
	}

	public Monster getFirstMonster() {
		return this.monsters.get(0);
	}

	public void addDead(GameCharacters dead) {
		this.deads.add(dead);
	}

	public void removeDead(GameCharacters dead) {
		this.deads.remove(dead);
	}

	public List<GameCharacters> getDeads() {
		return this.deads;
	}

	public GameCharacters getFirstDead() {
		return this.deads.get(0);
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public List<Item> getItems() {
		return this.items;
	}

	public Item getFirstItem() {
		return this.items.get(0);
	}

	public boolean isExit() {
		return false;
	}

	public void addNeighbour(Direction d, Room r) {
		this.neighbour.put(d, r);
	}

	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}

	public Room getNeighbour(Direction d) {
		return this.neighbour.get(d);
	}

	public Map<Direction, Room> getNeighbours() {
		return this.neighbour;
	}

	public String toString() {
		return new String();
	}

	public void interact(Player player) {
		System.out.println("It looks like nothing special can happen in this room...");
		this.explored = true;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isExplored() {
		return this.explored;
	}
}
