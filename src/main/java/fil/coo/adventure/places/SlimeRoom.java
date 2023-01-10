package fil.coo.adventure.places;

import fil.coo.adventure.entities.monsters.util.Slime;

public class SlimeRoom extends Room{ 
    public SlimeRoom () {
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
        this.addMonster(new Slime());
    }

    public void interact() {
        System.out.println("This room is nasty, even if i've found something that look like a potion i'm not sure if i wan't to drink it.");
        System.out.println("Drink it ?");
        // TODO : allow the player to interact with this event
        // Not drinking it end the event, drinking give him a strenght buff
    }
}
