package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    protected String toisenSiirto() {
        return scanner.nextLine();
    }

}
