package Text_Based_RPG;

public class Player {
    static int playerHealth = 100; // We'll set the players starting health here because it'll be static. No need to change the base later
    static int strength = 6; // base strength being 6 damage ranging from 0 to 5 with 16% chance to miss the target
                             // The more the strength attribute gets the smaller teh chance to miss
    // Functions Section
    static int attack(){
        // About 16% chance to miss
        int attackDamage = (int)(Math.random() * strength);
        return attackDamage;
    }

    // Add a healing function, reminding you cause I know you'll forget
    // Now I am talking to myself in code...
}

