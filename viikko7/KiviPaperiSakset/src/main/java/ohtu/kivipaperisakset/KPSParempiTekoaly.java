package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String toisenSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void cleanUp(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }

}
