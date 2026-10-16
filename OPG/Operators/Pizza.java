public static void main(String[]args){

    int pocetPizz = 4;
    double cenaZaKus = 7.50;
    boolean jeVikend = false;
    boolean maZlavovyKupon = false;

    double zakladnaCena = (pocetPizz * cenaZaKus);

    boolean dopravaZdarma = (pocetPizz >=3 || maZlavovyKupon && !jeVikend);

    double cenaDopravy = dopravaZdarma ? 0.0 : 3.50;

    double zlava = zakladnaCena > 20.0 ? 0.10 : 0.0;

    double hodnotaZlavy = zakladnaCena * zlava;
    double celkovaSuma = (zakladnaCena - hodnotaZlavy) + cenaDopravy;
    

    System.out.println("Počet pizza:            " + pocetPizz + " ks");
    System.out.println("Cena za kus:           " + String.format("%.2f", cenaZaKus) + " €");
    System.out.println("Základná cena:         " + String.format("%.2f", zakladnaCena) + " €");
    System.out.println("Doprava zdarma:        " + (dopravaZdarma ? "Áno" : "Nie"));
    System.out.println("Cena dopravy:          " + String.format("%.2f", cenaDopravy) + " €");
    System.out.println("Uplatnená zľava:       " + (int)(zlava * 100) + " % (-" + String.format("%.2f", hodnotaZlavy) + " €)");
    System.out.println("---------------------------------------"); // Divider cuz UI
    System.out.println("CELKOVÁ SUMA NA ÚHRADU: " + String.format("%.2f", celkovaSuma) + " €");
}