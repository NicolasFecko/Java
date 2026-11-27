package classObj;

public class space {

    VesmirnaSonda sonda1 = new VesmirnaSonda();

    {
        sonda1.nazov = "Voyager 1";
        sonda1.cielovaPlaneta = "Jupiter/Medzihviezdny priestor";
        sonda1.rokVypustenia = 1977;
        sonda1.rychlostKmS = 17.0f;
        sonda1.jeAktivna = true;

        VesmirnaSonda sonda2 = sonda1;
        sonda2.rychlostKmS = 17.2f;

        VesmirnaSonda sonda3 = new VesmirnaSonda();
        sonda3.nazov = "New Horizons";
        sonda3.cielovaPlaneta = "Pluto";
        sonda3.rokVypustenia = 2006;
        sonda3.rychlostKmS = 16.26f;
        sonda3.jeAktivna = true;

        System.out.println("Stav sonda1:");
        sonda1.zobrazStav();
        System.out.println("Stav sonda2:");
        sonda2.zobrazStav();
        System.out.println("Stav sonda3:");
        sonda3.zobrazStav();
    }

    public static void main(String[] args) {
        new space();
    }
}
