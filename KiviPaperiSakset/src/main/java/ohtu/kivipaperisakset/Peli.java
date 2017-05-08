
package ohtu.kivipaperisakset;

import static ohtu.kivipaperisakset.KPSParempiTekoaly.lueSiirto;

public class Peli {
    private Tuomari tuomari;
    private Pelaaja pelaajaEka;
    private Pelaaja pelaajaToka;
    private IO io;

    public Peli(Tuomari tuomari, Pelaaja pelaaja, IO io) {
        this.tuomari = tuomari;
        this.pelaajaToka = pelaaja;
        this.io = io;
    }
    
    public void pelaa() {
        io.print("Ensimmäisen pelaajan siirto: ");
        SiirtoTyyppi ekanSiirto = lueSiirto(io.lueSyote());
        SiirtoTyyppi tokanSiirto = pelaajaToka.annaSiirto();

        io.println("Tietokone valitsi: " + tokanSiirto);
    }
    
}
