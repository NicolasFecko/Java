// Welcome dear visitors of this I believe future code jungle!
// I want to learn Java for my Junior year of High school and what better way to learn than by making a project with no knowledge and bullying myself into submission
// This is a text-based RPG where you play as an IT technician new to the job and have to battle waves of PC components.
// Again I do not kow Java that well yet so you will find many inefficiencies and other shenanigans
// About the comments these are not AI as many annoying people would claim but rather just me genuinely enjoying the job.
// Starting date: 9th of July 2026
// Author: Nicolas Fecko (As found on the GitHub page)

// Total hours spent on this: 4

// I made this entire project in a separate folder called this
package Text_Based_RPG;

import java.util.Scanner;

// Mian program class
public class Main
{
    // Color codes to be used later for a better UI
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[32m";
    String RED = "\u001B[31m";

    // Hold the current enemy and player health separately from the class
    int currentPlayerHealth = Player.playerHealth;
    int currentRamHealth = RAM.ramHealth;
    // Had to relocate up here into the Main class because I needed it for more methods
    Scanner input = new Scanner(System.in); // Create a universal input scanner

    // This function just uses a scanner to get the players choice
    int getChoice(){
        System.out.print("1. Attack\n2. Heal\n\nYour choice: ");
        //int playerChoice = input.nextInt();
        return input.nextInt(); // This way the method returns the input without having to waste space in an additional variable
    }

    // This method processes the users choice and responds appropriately
    int processChoice(int playerChoice)
    {
        int playerAttack = Player.attack(); // Store the randomly generated damage dealt
        if (playerChoice == 1){
            System.out.println("Attacking..");

            if (playerAttack == 0){
                System.out.println("Well that's awkward.. You missed..\n");
            }
            else {
                System.out.println(GREEN + "Attack successful!\n" + RESET + "You dealt " + GREEN + playerAttack + RESET + " points of Damage\n");
                return playerAttack;
            }
        }

        else if (playerChoice == 2) {
            System.out.println("Healing..");
        }

        else {
            System.out.print("*Character turns around and looks at you in confusion");
        }

        // The Integer function had to return something
        return 0;
    }

    // A method to update the health allowing the games characters to actually die
    void update_Health(int playerAttack)
    {
        currentRamHealth = currentRamHealth - playerAttack;
        if (currentRamHealth < 0){
            currentRamHealth  = 0; // Added this function because often at the end of the fight health display was a negative number
        }
        currentPlayerHealth = currentPlayerHealth - RAM.ram_damage;
    }

    // Main program method holding the method directions and game story
    public void main(String[] args)
    {
        // So hear me out, I changed the name of the first enemy class twice already but why don't we give the game a little soul?
        // As if RPGs aren't nerdy enough I decided to build it on a story of an amateur technician
        System.out.print("Company: Good morning Technician, please tell us your name\n" + "You: ");
        // Store player name
        String playerName = input.nextLine();
        System.out.print("Company: Nice to meet you " + playerName + " But enough chitchat, now you will face off against your first job...\nRAM");
        System.out.println("\n--- Battle Arena ---\n");

        // Beginning of the first tutorial battle
        System.out.println("Opponent: RAM\n" + RED + "RAM health: " + currentRamHealth + RESET);
        System.out.println(GREEN + "Your health: " + currentPlayerHealth + RESET + "\n"); // Needed one more free line at the end

        // Main fight loop for the tutorial battle
        while (currentRamHealth > 0 && currentPlayerHealth > 0)
        {
            int choice = getChoice(); // Store the choice in a variable for later use
            int playerDamage = processChoice(choice);
            System.out.println("RAM attacks!\nDamage dealt: " + RED +  RAM.ram_damage + RESET + "\n");
            update_Health(playerDamage);
            System.out.println(RED + "RAM health: " + currentRamHealth + RESET);
            System.out.println(GREEN + "Player Health: " + currentPlayerHealth + RESET + "\n");
        }

        // End of the Tutorial battle
        System.out.println("\nCompany: Congratulations " + playerName + " you successfully repaired the RAM stick on this device and therefore proving yourself to be a capable technitian\n"
        + "But the best has yet to come!\n" + "Clock back in tomorrow, if you dare.\n" + "But first come here, I'll patch you up\n");
        currentPlayerHealth = Player.playerHealth; // Fully heals the player at the end of the fight
        System.out.print(GREEN + "Your Health: " + currentPlayerHealth + RESET); // Assures the player that he was actually healed

    }
}