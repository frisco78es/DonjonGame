package fil.coo.adventure.places.entity;

import fil.coo.adventure.entities.GameCharacters;
import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Dragon;
import fil.coo.adventure.places.Room;

public class TrappedRoom extends Room {
    public TrappedRoom() {
        super("Empty Room");
        Dragon dragon1 = new Dragon();
        dragon1.setGold(0);
        this.addDead(dragon1);
        Dragon dragon2 = new Dragon();
        dragon2.setGold(0);
        this.addDead(dragon2);
    }

    public void interact(Player player) {
        this.explored = true;
        System.out.println("Something is strange, very strange...");
        System.out.println("The 2 dragons skeleton in the room woke up and prepare to fight you.");
        while (this.getDeads().size() > 0) {
            GameCharacters gc = this.getFirstDead();
            if(gc instanceof Monster) {
                this.removeDead(gc);

            }
        }
        Dragon dragon1 = new Dragon();
        this.addMonster(dragon1);
        Dragon dragon2 = new Dragon();
        this.addMonster(dragon2);
    }
}
