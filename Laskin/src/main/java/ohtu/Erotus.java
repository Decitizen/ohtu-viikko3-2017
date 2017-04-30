
package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;
    private Sovelluslogiikka sovellus;
    private int peruutusArvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, 
                JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.arvo = Integer.parseInt(syotekentta.getText());
        this.peruutusArvo = Integer.parseInt(tuloskentta.getText());
        sovellus.miinus(this.arvo);
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + peruutusArvo);
        sovellus.setTulos(peruutusArvo);
    }
    
}
