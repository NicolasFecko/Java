package classObj;

public class VesmirnaSonda {
    String nazov;
    String cielovaPlaneta;
    int rokVypustenia;
    float rychlostKmS;
    boolean jeAktivna;

    void zobrazStav(){
        System.out.println("Nazov: " + nazov);
        System.out.println("CielovaPlaneta: " + cielovaPlaneta);
        System.out.println("RokVypustenia: " + rokVypustenia);
        System.out.println("JeAktivna: " + jeAktivna);
        System.out.println(" ");
    }
}
