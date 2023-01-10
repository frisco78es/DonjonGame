package fil.coo.adventure.places;

import fil.coo.adventure.entities.Player;

public class Shop extends Room {
    public void interact (Player player) {
        System.out.println("You found a not very welcoming shop offering you to buy some items in exchange of your precious gold.");
        System.out.println("You can either enter the shop or leave. What would you do ?");
        System.out.println("ENTER / LEAVE ?");
        // TODO ask console to write ENTER or LEAVE
        String playerAnswer = "ENTER";
        switch(playerAnswer) {
            case "ENTER":
                System.out.println("You decide to enter the shop and are welcome by a small goblin, welcoming you to look at his items.");
                System.out.println("You find some healing potions, being trade for 30 golds.");
                System.out.println("You find some stength potions, being trade for 50 golds.");
                System.out.println("What would you do ?");
                System.out.println("HEAL / STRENGH / LEAVE ?");
            case "LEAVE":
                System.out.println("This shop don't look interesting, you are leaving this shop.");
        }
    }
}
