package ohtu.kivipaperisakset;

public class TavallinenTekoaly implements Pelaaja {
    private static int siirto = 0;
    private static final int JAKOJAANNOS = 3;

    @Override
    public SiirtoTyyppi annaSiirto() {
        this.siirto++;
        this.siirto = this.siirto % JAKOJAANNOS;

        if (this.siirto == 0) {
            return SiirtoTyyppi.KIVI;
        } else if (this.siirto == 1) {
            return SiirtoTyyppi.PAPERI;
        } else {
            return SiirtoTyyppi.SAKSET;
        }
    }

    @Override
    public void asetaSiirto(SiirtoTyyppi ekanSiirto) {
    }

}
