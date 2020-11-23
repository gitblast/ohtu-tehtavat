package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin tulee olla positiivinen");
        }

        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon tulee olla positiivinen");
        }

        luvut = new int[kapasiteetti];

        this.alustaTaulukko();
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public void alustaTaulukko() {
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % luvut.length == 0) {
                int[] taulukko = new int[luvut.length + kasvatuskoko];
                kopioiTaulukko(luvut, taulukko);
                luvut = taulukko;
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean poista(int luku) {
        boolean loytyy = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                loytyy = true;
            }

            if (loytyy && i + 1 < alkioidenLkm) {
                luvut[i] = luvut[i + 1];
            }
        }

        if (loytyy) {
            alkioidenLkm--;
        }

        return loytyy;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvut[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += luvut[i];
                tuotos += ", ";
            }
            tuotos += luvut[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < b.alkioidenLkm; i++) {
            if (!a.kuuluu(b.luvut[i])) {
                a.lisaa(b.luvut[i]);
            }
        }

        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko j = new IntJoukko();

        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.kuuluu(a.luvut[i])) {
                j.lisaa(a.luvut[i]);
            }
        }

        return j;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.alkioidenLkm; i++) {
            a.poista(b.luvut[i]);
        }

        return a;
    }

}
