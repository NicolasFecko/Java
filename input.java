// had to import my ability to take user input
import java.util.Scanner;

void main() {
    Scanner name = new Scanner(System.in);
    System.out.println("Please enter your name: ");
    String name_read = name.nextLine();

    Scanner age = new Scanner(System.in);
    System.out.println("Please enter your age: ");
    // We want to take age in an Interger
    int age_read = age.nextInt();

    Scanner favorite_language = new Scanner(System.in);
    System.out.println("Please enter your favorite programming language: ");
    String language_read = favorite_language.nextLine();

    Scanner experience = new Scanner(System.in);
    System.out.println("How much experience do you have in the field? (in years)");
    int experience_read = experience.nextInt();

    System.out.println("\n--- Profile ---");
    System.out.println("Name: " + name_read);
    System.out.println("Age: " + age_read);
    System.out.println("Favorite Programming Language: " + language_read);
    System.out.println("Experience: " + experience_read);
    System.out.println("\nStatus: ");

    // if statements looking like Yandere simulator special
    if (experience_read == 0) {
        System.out.println("Beginner");
    }
    if ((experience_read > 0) && (experience_read < 4)) { // Freestyle syntax guess
        System.out.println("Learning");
    }
    if (experience_read >= 4) {
        System.out.println("Veteran");
    }
    if (experience_read < 0){
        System.out.println("fym?");
    }
}
