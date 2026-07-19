package RPG;

public class Player {
    // Base
    String name;

    // set at the start
    String gender;

    //
    int age;


    // Character stats
    int health;
    int energy;
    int happiness;


    // Stats
    int cash;
    int bankBalance;

    // Career stats
    String educationReached;
    int academyPoint;
    String currentJob;
    int salaryRange;


    // Skill stats
    int strength;
    int intelligence;
    int driving;
    int firearms;
    int hacking;
    int charisma;


    // Constructor automatically assigns values upon object creation
    public Player(){
        age = 18; // The game will start the user off at 18 years old
        health = 100;
        energy = 100;
        happiness = 50; // Max will be 100 just at the start of the game make it 50

        // Stats
        cash = 0;
        bankBalance = 100; // $100 for start in the bank, literally me rn

        // Career
        educationReached = "High School";
        academyPoint = 0;

        /*
        High school -> 0
        Generic University -> 1
        business university -> 2
        engineering degree -> 3
        medicine -> 4

        (Will add more later)
        */

        currentJob = "Unemployed"; // I'll probably change how this feature works later
        salaryRange = 0; // With this teh code will determine the importance / salary amount of the job with an integer

        // Skills
        strength = 1;
        intelligence = 1;
        charisma = 1; // Ain't exactly sure how this is a skill, but you ain't good at it yet

        driving = 0; // No driver's license yet
        firearms = 0; // No arms license yet
        hacking = 0; // This thing actually ain't as easy as movies make it look

    }

}
