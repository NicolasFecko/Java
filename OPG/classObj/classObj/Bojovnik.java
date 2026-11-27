package classObj;

public class Bojovnik {
    String meno;
    String trieda;
    int zivoty;
    int silaUtoku;

    void nastavstavBojovnika(String m, String t, int z, int s) {
        meno = m;
        trieda = t;
        zivoty = z;
        silaUtoku = s;
    }

    void zobrazProfil() {
        System.out.println("Meno: " + meno);
        System.out.println("Trieda: " + trieda);
        System.out.println("Zivoty: " + zivoty);
        System.out.println("Sila utoku: " + silaUtoku);
    }

    void zautoc(Bojovnik ciel) {
        System.out.println(meno + " utoci na " + ciel.meno + ".");
        ciel.zivoty -= silaUtoku;
        if (ciel.zivoty < 0) {
            ciel.zivoty = 0;
        }
    }
}
