package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.util.TrappedChest;
import fil.coo.adventure.entities.monsters.util.Slime;
import fil.coo.adventure.places.Room;

public class SlimeRoom extends Room {
    public final static String name = "SlimeRoom";

    public SlimeRoom() {
        super("Slime Room");
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addItem(new TrappedChest());
    }

    public void interact(Player player) {
        this.explored = true;
        System.out.println(
                "This room is nasty, even if i've found something that look like a potion i'm not sure if i wan't to drink it.");
        System.out.println("Drink it ?");
        System.out.println("YES / NO ?");
        Boolean bool = true;
        while (bool) {
            String playerAnswer = this.scanner.nextLine();
            switch (playerAnswer.toLowerCase()) {
                case "yes":
                    player.addStrength(5);
                    System.out.println("This potion have a nasty taste, buy you seem more powerful after drinking it.");
                    System.out.println("SYS: 5 Strength added to your character.");
                    bool = false;
                    break;
                case "no":
                    System.out.println("Too dangerous for you, you're leaving.");
                    bool = false;
                    break;
                default:
                    System.out.println("SYS: You entered a wrong command, please try again.");
                    break;
            }
        }
    }
}
