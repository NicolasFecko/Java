public class Hrac {

    public static int celkovoHracov = 0;

    private String meno;
    private int skore;

    public Hrac(String meno, int skore) {
        this.meno = meno;
        this.skore = skore;
    }

    public static void main(String[] args) {

        int staryPocet = celkovoHracov++;

        int novyPocet = ++celkovoHracov;

        System.out.println("--- Porovnanie inkrementácie ---");
        System.out.println("Hodnota staryPocet postfix: " + staryPocet);
        System.out.println("Hodnota novyPocet prefix:   " + novyPocet);
        System.out.println("Aktuálna hodnota celkovoHracov: " + celkovoHracov);
    }
}