// An RPG where the player has a big city to explore and multiple activities to do such as finding a job, casino, crime and random world events
// For start I'll make the player creation and save

package RPG;
import java.util.Scanner; // Gotta import my input
import java.util.concurrent.TimeUnit; // Need import to use the delay function I use for animations

public class Main {
    static Scanner input = new Scanner(System.in); // Create a universal input scanner

    public static Player characterCreation(){

        Player player = new Player(); // Create a new player object

        System.out.println("-- Character Creation --");

        System.out.print("Character name: ");
        player.name = input.nextLine();


        while (true) {
            System.out.println("Character Gender: \n1. Male\n2. Female");
            System.out.print("Enter choice: ");

            String genderChoice = input.nextLine().trim(); // Store it in a string to overcome the absent frontal lobe of the user

            // Use a switch case to directly assign the gender from the choice
            switch (genderChoice) {
                case "1" -> player.gender = "Male";
                case "2" -> player.gender = "Female";

                // If the user gives the wrong input
                default -> {
                    System.out.println("Invalid input. Please enter 1 or 2. \n");
                    continue;
                }
            }
            break;

        }
        return player;
    } // End of characterCreation() method


    static void cityNavigation(Player player) throws InterruptedException {
        while (true) {
            System.out.println("--- City ---\n");

            System.out.print("Your choice: ");
            String cityChoice = input.nextLine();

            switch (cityChoice){
                case "1" -> System.out.println("Idk yet bro");
                //...
                case "back" -> {
                    TimeUnit.SECONDS.sleep(1);
                    return;
                }
                default -> {
                    System.out.println("Invalid input! Please try again..");
                    continue;
                    }
                }
            } // End of loop

        } // End of cityNavigation



    static void checkStats(Player player) throws InterruptedException {
        System.out.println("-- Player Stats -- ");
        System.out.println("Name: " + player.name);
        System.out.println("Gender: " + player.gender);
        System.out.println("Age: "+ player.age);

        System.out.println("\nHealth: " + player.health);
        System.out.println("Energy: " + player.energy);
        System.out.println("Happiness: " + player.happiness);

        System.out.println("\nCash: " + player.cash);
        System.out.println("Bank Balance: " + player.bankBalance);

        System.out.println("\nEducation reached: " + player.educationReached);

        System.out.println("\nCurrent job: " + player.currentJob);

        System.out.println("\nStrength: " +player.strength);
        System.out.println("Intelligence: " + player.intelligence);
        System.out.println("Charisma: " + player.charisma);

        System.out.println("\nDriving: " + player.driving);
        System.out.println("Firearms: " + player.firearms);
        System.out.println("Hacking: " + player.hacking);

        while (true) {
            System.out.print("\n\nType 'back' to return: ");
            String checkStatsChoice = input.nextLine().trim();

            switch (checkStatsChoice){
                case "back" -> {
                    TimeUnit.SECONDS.sleep(1);
                    return;
                }
                default -> {
                        System.out.println("Invalid input! Try again..");
                        continue;
                }
            }
        }

    }

    // I ain't exactly sure what I'll do with this yet
    static void playerInventory(){

    }

    static void gameMenu(Player player) throws InterruptedException { // In the parameters pass the player object from the Player class for later use inside the method
        System.out.println("\n");
        System.out.println("Name: " + player.name);
        System.out.println("Age: " + player.age + "\n");
        System.out.println("Health: " + player.health);
        System.out.println("Energy: " + player.energy);
        System.out.println("Happiness: " + player.happiness + "\n");
        System.out.println("Cash: $" + player.cash);
        System.out.println("Bank Balance: $" + player.bankBalance + "\n\n");

        while (true) {
            System.out.println("""
                    1. Check stats
                    2. Explore the city
                    3. Inventory
                    4. Save game
                    5. Exit game
                    """
            );
            System.out.print("Your choice: ");
            String gameMenuChoice = input.nextLine().trim();

            switch (gameMenuChoice) {
                case "1" -> checkStats(player);
                case "2" -> cityNavigation(player);
                case "3" -> playerInventory();
                case "4" -> System.out.println("Saving...");
                case "5" -> System.exit(0);

                default -> {
                    System.out.println("Invalid input!\n Try again");
                    continue;
                }
            }

        }



    } // End of gameMenu

    public static void main(String[] args) throws InterruptedException {

        Player player = characterCreation(); // Initialize character creation

        System.out.println("\n\nHello " + player.name + ", Welcome to the city");


        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
        TimeUnit.SECONDS.sleep(1); // This bunch of code here creates a sort of loading animation

        // Here I am thinking to create a game menu. Like a main menu, but it presents the player with choices on how to progress the game
        gameMenu(player);
    }
}