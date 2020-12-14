package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto() {
        return tekoaly.annaSiirto();
    }

    @Override
    protected void cleanUp(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }
}
