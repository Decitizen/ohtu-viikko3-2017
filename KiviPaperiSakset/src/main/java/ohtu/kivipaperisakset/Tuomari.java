package ohtu.kivipaperisakset;

// Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.
public class Tuomari {

    private int pelaajaEkaVoitot;
    private int pelaajaTokaVoitot;
    private int tasapelitLkm;

    public Tuomari() {
        this.pelaajaEkaVoitot = 0;
        this.pelaajaTokaVoitot = 0;
        this.tasapelitLkm = 0;
    }

    public void kirjaaVoitto(SiirtoTyyppi ekanSiirto, SiirtoTyyppi tokanSiirto) {
        if (ekanSiirto == tokanSiirto) {
            tasapelitLkm++;
        } else if (pelaajaEkaVoittaa(ekanSiirto, tokanSiirto)) {
            pelaajaTokaVoitot++;
        } else {
            pelaajaEkaVoitot++;
        }
    }

    private static boolean pelaajaEkaVoittaa(SiirtoTyyppi eka, SiirtoTyyppi toka) {
        if (eka == SiirtoTyyppi.KIVI && toka == SiirtoTyyppi.SAKSET) {
            return true;
        } else if (eka == SiirtoTyyppi.SAKSET && toka == SiirtoTyyppi.PAPERI) {
            return true;
        } else if (eka == SiirtoTyyppi.PAPERI && toka == SiirtoTyyppi.KIVI) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Pelitilanne: " 
                + pelaajaEkaVoitot + " - " 
                + pelaajaTokaVoitot + "\n"
                + "Tasapelit: " + tasapelitLkm;
        
    }
}