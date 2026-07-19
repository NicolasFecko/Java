// An RPG where the player has a big city to explore and multiple activities to do such as finding a job, casino, crime and random world events
// For start I'll make the player creation and save

package RPG;
import java.util.Scanner; // Gotta import my input
import java.util.concurrent.TimeUnit; // Need import to use the delay function I use for animations

public class Main {
    static Scanner input = new Scanner(System.in); // Create a universal input scanner


    // Color codes to be used later for a better UI
    static String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";
    static String WHITE = "\u001B[37m";

    static String WHITE_BACKGROUND = "\u001B[47m";

    public static int getValidInt(Scanner input) {
        while (!input.hasNextInt()) {
            String garbage = input.next(); // eat the letters/words
            System.out.println("'" + garbage + "' is not a number.");
            System.out.print("Try entering an actual amount: ");
        }
        return input.nextInt();
    }

    static void passTime(Player player, int hours){

        player.hour += hours;


        while (player.hour >= 24) {
            player.hour -= 24;
            player.day++;
        }
    } //End of passTime


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
            System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET);

            System.out.println("--- City ---\n");
            // Time to build the city
            System.out.print("""
                            1. Bank
                            2. Super Market
                            3. Gym
                            4. Post Office
                            5. Job Office
                            6. Casino
                            
                            0. Return
                            """);
            // For now only 6 locations. I'll add a lot more in later updates

            System.out.print("Your choice: ");
            String cityChoice = input.nextLine();

            switch (cityChoice){
                case "1" -> bank(player);
                case "2" -> System.out.println("Supermarket");
                case "3" -> gym();
                //...
                case "0" -> {
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


    static void gym(){
        // For later
        // You increase your stats, but it costs energy and also have to pay entry fee
    }

    static void bank(Player player){
        passTime(player, 1);
        System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET + "\n");
        System.out.println("Welcome to the bank!");
        while (true) {
            System.out.print("Would you like to 1. deposit or 2. withdraw?\nIf you wish to exit type 0.\nYour choice: ");
            String bankAction = input.nextLine();

            switch (bankAction){
                case "2" -> withdraw(player);
                case "1" -> deposit(player);
                case "0" -> {
                    return;
                }


                    default ->{
                        System.out.println("Invalid input, please try again!");
                        continue;
                    }
            }
        }
    } // End of bank

    static void withdraw(Player player){
            System.out.print("\nHow much would you like to withdraw?\nYou: ");
            while (true) {
                int withdrawAmount = getValidInt(input);
                input.nextLine(); // Delete the leftovers

                if (player.bankBalance < withdrawAmount) {
                    System.out.println("I am sorry but you don't have enough money in the bank.\nYou currently have: " + player.bankBalance);
                    continue;
                }
                player.cash += withdrawAmount;
                player.bankBalance -= withdrawAmount;
                System.out.println("Here's you cash.");
                break;
            }
    } // End of Withdraw

    static void deposit(Player player){
        System.out.println("\nHow much would you like to deposit?");
        while (true){
            int depositAmount = getValidInt(input);
            input.nextLine();

            if (player.cash < depositAmount){
                System.out.println("I am sorry but you don't have enough cash to make this transaction. \nYou have only $" + player.cash);
                continue;
            }
            player.bankBalance += depositAmount;
            player.cash -= depositAmount;
            System.out.println("Transaction successful, have a nice day!");
            break;

        }
    } // End of Deposit


    static void checkStats(Player player) throws InterruptedException {
        System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET);

        System.out.println("-- Player Stats -- ");
        System.out.println("Name: " + player.name);
        System.out.println("Gender: " + player.gender);
        System.out.println("Age: "+ player.age);

        System.out.println("\nHealth: " + player.health);
        System.out.println("Energy: " + player.energy);
        System.out.println("Happiness: " + player.happiness);

        System.out.println("\nCash: $" + player.cash);
        System.out.println("Bank Balance: $" + player.bankBalance);

        System.out.println("\nEducation reached: " + player.educationReached);

        System.out.println("\nCurrent job: " + player.currentJob);

        System.out.println("\nStrength: " +player.strength);
        System.out.println("Intelligence: " + player.intelligence);
        System.out.println("Charisma: " + player.charisma);

        System.out.println("\nDriving: " + player.driving);
        System.out.println("Firearms: " + player.firearms);
        System.out.println("Hacking: " + player.hacking);

        while (true) {
            System.out.print("\n\nType '0' to return: ");
            String checkStatsChoice = input.nextLine().trim();

            switch (checkStatsChoice){
                case "0" -> {
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

    // We let the player sleep for 8 hours
    static void sleep(Player player){
        player.energy = 100; // Make sure the player is well rested
        player.health += 10; // Heal a little

        if (player.health > 100){
            player.health = 100; // Makes sure the max health stays at 100
        }
        passTime(player, 8); // Can't forget to let time pass
        // I could make it go into 8am on a new day but what if someone wants to sleep only for a shorter time

        // Also I should add a cooldown for sleep... Later
    }

    static void gameMenu(Player player) throws InterruptedException { // In the parameters pass the player object from the Player class for later use inside the method

        while (true) {
            System.out.println("\n");
            System.out.println(WHITE_BACKGROUND + "-------------------------------------------------" + RESET);

            System.out.println("Day " + player.day);
            System.out.println("Time: " + player.hour + ":00\n");

            System.out.println("Name: " + player.name);
            System.out.println("Age: " + player.age + "\n");
            System.out.println("Health: " + player.health);
            System.out.println("Energy: " + player.energy);
            System.out.println("Happiness: " + player.happiness + "\n");
            System.out.println("Cash: $" + player.cash);
            System.out.println("Bank Balance: $" + player.bankBalance + "\n\n");


            System.out.println("""
                    1. Check stats
                    2. Explore the city
                    3. Inventory
                    4. Sleep
                    5. Save game
                    6. Exit game
                    """
            );
            System.out.print("Your choice: ");
            String gameMenuChoice = input.nextLine().trim();

            switch (gameMenuChoice) {
                case "1" -> checkStats(player);
                case "2" -> {
                    cityNavigation(player);
                    passTime(player, 1);
                }
                case "3" -> playerInventory();
                case "4" -> {
                    System.out.println("Going to sleep...");
                    sleep(player);
                }
                case "5" -> System.out.println("Saving...");
                case "6" -> System.exit(0);

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


        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(".");
        //TimeUnit.SECONDS.sleep(1); // This bunch of code here creates a sort of loading animation

        // Here I am thinking to create a game menu. Like a main menu, but it presents the player with choices on how to progress the game
        gameMenu(player);
    }
}
