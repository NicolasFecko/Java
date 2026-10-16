import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        float zostatok = 100;
        int volba = 0;

        float vklad;
        float vyber;

        Scanner input = new Scanner(System.in);

        do {
            System.out.print("""
                1- Zostatok
                2- Vklad
                3- Výber
                4- Koniec
                Your choice: """);

            volba = input.nextInt();

            switch(volba){
                case 1: System.out.println("Zostatok: " + zostatok);
                break;

                case 2: {
                    System.out.println("Zostatok: " + zostatok);
                    System.out.print("How much do you want to Put in: ");
                    vklad = input.nextFloat();
                    zostatok += vklad;

                }
                break;

                case 3: {
                    System.out.println("Zostatok: " + zostatok);
                    System.out.print("How much do you want to take out: ");
                    vyber = input.nextFloat();
                    zostatok -= vyber;
                }
                break;

                case 4: break;

                default: System.out.println("Invalid input");
            }
        }
        while(volba!=4);
    }
}