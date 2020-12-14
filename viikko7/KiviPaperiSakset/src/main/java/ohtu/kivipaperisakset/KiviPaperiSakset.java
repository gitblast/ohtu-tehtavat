package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {

    public static KiviPaperiSakset pelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KiviPaperiSakset vsTekoaly() {
        return new KPSTekoaly();
    }

    public static KiviPaperiSakset vsParempiTekoaly() {
        return new KPSParempiTekoaly();
    }

    public static final Scanner scanner = new Scanner(System.in);

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = ensimmaisenSiirto();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();
        System.out.println(tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = ensimmaisenSiirto();

            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();
            System.out.println(tokanSiirto);

            cleanUp(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        return scanner.nextLine();
    }

    abstract protected String toisenSiirto();

    protected void cleanUp(String siirto) {

    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
