import java.util.Scanner;

public class TrainingTracker {

    public static void privitajUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter meno: ");
        String meno = sc.nextLine();

        System.out.print("Enter aktivita: ");
        String aktivita = sc.nextLine();

        System.out.print("Enter trvanie: ");
        int trvanie = sc.nextInt();

        System.out.print("Enter ciel: ");
        int ciel = sc.nextInt();

        double spaleneKalorie = vypocitajSpaleneKalorie(aktivita, trvanie);
        boolean splneny = jeCielSplneny(spaleneKalorie, ciel);

        System.out.println("Meno: " + meno);
        System.out.println("Spalene kalorie: " + spaleneKalorie);
        System.out.println("Ciel splneny: " + splneny);

        sc.close();
    }

    public static double vypocitajSpaleneKalorie(String aktivita, int trvanie) {
        double rate = 5.0;

        switch (aktivita.trim().toLowerCase()) {
            case "beh":
                rate = 10.5;
                break;
            case "bicikel":
                rate = 8.0;
                break;
            case "plavanie":
                rate = 9.0;
                break;
            case "ine":
                rate = 5.0;
                break;
        }

        return rate * trvanie;
    }

    public static boolean jeCielSplneny(double spaleneKalorie, int ciel) {
        return spaleneKalorie >= ciel;
    }

    public static void main(String[] args) {
        privitajUser();
    }
}