// An RPG where the player has a big city to explore and multiple activities to do such as finding a job, casino, crime and random world events
// For start I'll make the player creation and save

package RPG;
import java.util.Scanner; // Gotta import my input
import java.util.concurrent.TimeUnit; // Need import to use the delay function I use for animations

public class Main {
    static Scanner input = new Scanner(System.in); // Create a universal input scanner


    // Color codes to be used later for a better UI
    static String RESET = "\u001B[0m";
    static String WHITE_BACKGROUND = "\u001B[47m";

    public static int getValidInt(Scanner input) {
        while (!input.hasNextInt()) {
            String garbage = input.next(); // eat the letters/words
            System.out.println("'" + garbage + "' is not a number.");
            System.out.print("Try entering an actual amount: ");
        }
        return input.nextInt();
    } // End of getValidInt

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
                            7. Restaurant
                            8. Corporate Office
                            9. Construction site
                            
                            0. Return
                            """);
            // For now only 6 locations. I'll add a lot more in later updates

            System.out.print("Your choice: ");
            String cityChoice = input.nextLine();

            switch (cityChoice){
                case "1" -> bank(player);
                case "2" -> System.out.println("Supermarket");
                case "3" -> gym(player);
                case "4" -> {
                    // Post office case
                    if (player.hour >= 7 && player.hour <= 18){
                        postOffice(player);
                    }
                    else {
                        System.out.println("The Post office is closed. Work hours are from 7:00 to 18:00");
                    }
                } // End of case 4
                case "5" -> System.out.println("Welcome to the Job Office!");
                case "6" -> System.out.println("Welcome to the casino!");
                case "7" -> restaurant(player);
                case "8" -> corporateOffice(player);
                case "9" -> constructionSite(player);

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

    static void constructionSite(Player player){
        while (true){
            System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET + "\n");
            System.out.println("\n-- Construction site --");
            System.out.println("""
                                1. Work
                                0. Exit""");
            System.out.print("Your Choice: ");
            String constructionChoice = input.nextLine().trim();

            switch (constructionChoice){
                case "1" -> {
                    // First I need to check if the player actually works there
                    if ("Construction worker".equals(player.currentJob)){ // This way I avoid the program crashing if the player id unemployed
                        startWorkShift(player);
                    }
                    else {
                        System.out.println("I am sorry, you don't work here.");
                    }
                } // End of case 1
                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid input! Please try again..");
                    continue;
                }

            }

        }
    } // End of constructionSite

    static void corporateOffice(Player player){
        while (true){
            System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET + "\n");
            System.out.println("\n-- Corporate Office --");
            System.out.println("""
                                1. Work
                                0. Exit""");
            System.out.print("Your Choice: ");
            String constructionChoice = input.nextLine().trim();

            switch (constructionChoice){
                case "1" -> {
                    // First I need to check if the player actually works there
                    if ("Secretary".equals(player.currentJob)){ // This way I avoid the program crashing if the player id unemployed
                        startWorkShift(player);
                    }
                    else {
                        System.out.println("I am sorry, you don't work here.");
                    }
                } // End of case 1
                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid input! Please try again..");
                    continue;
                }

            }

        }
    } // End of corporateOffice

    static void restaurant(Player player){
        passTime(player, 1); // Pass time by an hour for travel to the establishment
        System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET + "\n");

        while (true) {
            System.out.println("Welcome to the restaurant!");
            System.out.println("""
                    1. Order
                    2. Begin Work shift
                    0. Exit""");

            System.out.print("Your choice: ");
            String restaurantChoice = input.nextLine().trim();

            switch (restaurantChoice){
                case "1" -> order(player);
                case "2" -> {
                    // First I need to check if the player actually works there
                    if ("Waiter".equals(player.currentJob)){ // This way I avoid the program crashing if the player id unemployed
                        startWorkShift(player);
                    }
                    else {
                        System.out.println("I am sorry, you don't work here.");
                    }
                } // End of case 2

                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid input! Please try again..");
                    continue;
                }
            }
        }
    } // End of restaurant

    static void startWorkShift(Player player){
            // In order to start the work shift I need to move time according to his job and deposit money.
        System.out.println("\n\nWorking...");
        passTime(player, player.workShift);
        player.bankBalance += (player.salaryPerHour * player.workShift); // Deposit money to the player for his work
        System.out.println("Work shift finished!\n It is currently: " + player.hour + ":00\nYou earned: $" + (player.salaryPerHour * player.workShift));
    }

    static void order(Player player){
        // later when I add a hunger and thirst Function
    }


    static void postOffice(Player player){
        // I am thinking you enter the post office, buy a newspaper and there you see some job offers that you can react to
        // The post office also needs work hours so you can't just stroll in there at midnight

        // Let's say work hours from 7:00 - 18:00
        while (true) {
            System.out.println("\n" +WHITE_BACKGROUND + "-------------------------------------------------" + RESET);
            System.out.println("Welcome to the post office, what would you like?");
            System.out.println("""
                    1. Buy a newspaper
                    2. Idk yet, for later updates
                    0. Exit""");

            System.out.print("Your choice: ");
            String postOfficeChoice = input.nextLine().trim();

            switch (postOfficeChoice){
                case "1" -> {
                    if (makePurchase(player, 2)){ // deduct $2 for the newspaper
                        buyNewspaper(player);
                    }
                }
                case "2" -> System.out.println("Idk yet, bro");

                case "0" -> {
                    return;
                }

                default -> {
                    System.out.println("Invalid Input. Please try again..");
                    continue;
                }
            }
        }

    }

    static void buyNewspaper(Player player){
        while (true) {
            System.out.println("\n" + WHITE_BACKGROUND + "-------------------------------------------------" + RESET);
            System.out.println("\n--- City Newspaper --- \nJob listings: \n");

            System.out.println("1. Waiter: \nSalary: $4/hour\nShift: 6 hours\n");
            System.out.println("2. Secretary: \nSalary: $5/hour\nShift: 8 hours\n");
            System.out.println("3. Construction: \nSalary: $5/hour\nShift: 10 hours\n");
            System.out.println("0. Exit");

            System.out.print("Your Choice: ");
            String newsPaperChoice = input.nextLine().trim();

            switch (newsPaperChoice){
                case "1" -> newsJob(player,1);
                case "2" -> newsJob(player, 2);
                case "3" -> newsJob(player, 3);

                case "0" -> {
                    return;
                }

                default -> {
                    System.out.println("Invalid Input. Please try again..");
                    continue;
                }
            }
        }
    } // End of buyNewspaper

    static boolean makePurchase(Player player, int price){
        while (true) {
            System.out.println("\n1. Cash or 2. card?");
            System.out.print("Your Choice: ");
            String purchaseChoice = input.nextLine().trim();

            switch (purchaseChoice){
                case "1" -> {
                    return cashPayment(player, price);
                }
                case "2" ->{
                    return cardPayment(player, price);
                }

                default -> {
                    System.out.println("Invalid Input. Please try again..");
                    continue;
                }
            }
        }
    } // End of makePurchase

    static boolean cardPayment(Player player, int price){
        if (player.bankBalance < price){
            System.out.println("Card declined");
            return false;
        }
        else {
            player.bankBalance -= price;
            System.out.println("Transaction successful");
            return true;
        }
    }

    static boolean cashPayment(Player player, int price){
        if (player.cash < price){
            System.out.println("Not enough money to make this purchase");
            return false;
        }
        else {
            player.cash -= price;
            return true;
        }
    }

    static void newsJob(Player player,int newsJob){
        if (newsJob == 1){
            if (haveJob(player)) {
                System.out.println("You must quit your other job first");
            }
            else {
                System.out.println("Congratulations, you got the job as a Waiter!\nYour starting salary will be $4/hour");
                player.salaryPerHour = 4; // Set players hourly rate to $4
                player.currentJob = "Waiter"; // Make sure to always remind the player of their employment status
                player.workShift = 6;
            }
        }
        else if (newsJob == 2){
            if (haveJob(player)) {
                System.out.println("You must quit your other job first");
            }
            else {
                System.out.println("Congratulations, you got the job as a Secretary!\nYour starting salary will be $4/hour");
                player.salaryPerHour = 5; // Set players hourly rate to $4
                player.currentJob = "Secretary"; // Make sure to always remind the player of their employment status
                player.workShift = 8;
            }
        }
        else if (newsJob == 3){
            if (haveJob(player)) {
                System.out.println("You must quit your other job first");
            }
            else {
                System.out.println("Congratulations, you got the job as a Construction worker!\nYour starting salary will be $4/hour");
                player.salaryPerHour = 5; // Set players hourly rate to $4
                player.currentJob = "Construction worker"; // Make sure to always remind the player of their employment status
                player.workShift = 10;
            }
        }
    } // end of newsJob

    static boolean haveJob(Player player){
        if (!player.currentJob.equals("Unemployed")){
            return true; // If you're not employed then you have a job resulting in True... It's obvious but my dumbahh had to double take
        }
        else {
            return false;
        }
    } // End of haveJob()

    static void gym(Player player){
        // For later
        // You increase your stats, but it costs energy and also have to pay entry fee

        if (!makePurchase(player, 6)){ // gym fee of $6
            System.out.println("You couldn't afford today's gym session.");
            return;
        }

        System.out.println("Welcome to the gym!");

        // Workout menu...


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

                if (withdrawAmount < 0){
                    System.out.println("You can't withdraw a negative number..");
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

            if (depositAmount < 0){
                System.out.println("You can't withdraw a negative number..");
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
        System.out.println("Current hourly rate: $" + player.salaryPerHour);

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

    static void jobScreen(Player player){
        while (true) {
            System.out.println(WHITE_BACKGROUND + "-------------------------------------------------" + RESET);
            System.out.println("--- Job Screen ---");

            System.out.println("Current job: " + player.currentJob);
            System.out.println("Hourly rate: $" + player.salaryPerHour);

            System.out.println("""
                                1. Quit job
                                0. Exit""");
            System.out.print("Your Choice: ");
            String jobScreenChoice = input.nextLine().trim();

            switch (jobScreenChoice){
                case "1" -> unemployinzation(player);
                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid input! Try again..");
                    continue;
                }
            }
        }
    } // End of jobScreen

    // I can use this above for quiting your job and later getting fired (so real and relatable)
    static void unemployinzation(Player player){ // hear me out, this is peak method naming
        if (haveJob(player)) {
            player.currentJob = "Unemployed";
            player.salaryPerHour = 0;
            player.workShift = 0;
        }
        else {
            System.out.println("You already don't have a job");
        }
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
                    5. Job Screen
                    6. Save game
                    7. Exit game
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
                case "5" -> jobScreen(player);
                case "6" -> System.out.println("Saving...");
                case "7" -> System.exit(0);

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
