
package ohtu.kivipaperisakset;

import java.util.ArrayList;
import java.util.List;

public class TekoalyParannettu implements Pelaaja {

    private static int kivienLkm;
    private static int paperienLkm;
    private static int saksienLkm;
    
    @Override
    public void asetaSiirto(SiirtoTyyppi siirto) {
        if (siirto == SiirtoTyyppi.KIVI) kivienLkm++;
        else if (siirto == SiirtoTyyppi.PAPERI) paperienLkm++;
        else if (siirto == SiirtoTyyppi.SAKSET) saksienLkm++;
    }

    @Override
    public SiirtoTyyppi annaSiirto() {
        if (kivienLkm + paperienLkm + saksienLkm < 2) {
            return SiirtoTyyppi.KIVI;
        } else if (kivienLkm > paperienLkm && kivienLkm > saksienLkm) {
            return SiirtoTyyppi.PAPERI;
        } else if (paperienLkm > kivienLkm && paperienLkm > saksienLkm) {
            return SiirtoTyyppi.SAKSET;
        } else {
            return SiirtoTyyppi.KIVI;
        }
    }
}
