package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly {

    

    public void pelaa() {
        IO io = new KonsoliIO();
        Tuomari tuomari = new Tuomari();
        TekoalyParannettu tekoaly = new TekoalyParannettu();

        io.print("Ensimmäisen pelaajan siirto: ");
        SiirtoTyyppi ekanSiirto = lueSiirto(scanner.nextLine());
        SiirtoTyyppi tokanSiirto = tekoaly.annaSiirto();

        io.println("Tietokone valitsi: " + tokanSiirto);


        while (true) {
            tuomari.kirjaaVoitto(ekanSiirto, tokanSiirto);
            io.println(tuomari.toString() + "\n");

            io.print("Ensimmäisen pelaajan siirto: ");
            String lueSyote = scanner.nextLine();
            if (!lueSyote.contains("[skp]")) {
                break;
            }
            ekanSiirto = lueSiirto(lueSyote);
            tokanSiirto = tekoaly.annaSiirto();
            io.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);
            
        }

        io.println("\nKiitos!");
        io.println(tuomari);
    }
    
    public static SiirtoTyyppi lueSiirto(String siirto) {
        if (siirto == "p") {
            return SiirtoTyyppi.PAPERI;
        } else if (siirto == "k") {
            return SiirtoTyyppi.KIVI;
        } else {
            return SiirtoTyyppi.SAKSET;
        }
    }
}
