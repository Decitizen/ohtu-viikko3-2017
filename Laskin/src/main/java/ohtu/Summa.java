
package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;
    private int arvo;
    private int peruutusArvo;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, 
                JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.arvo = Integer.parseInt(syotekentta.getText());
        this.peruutusArvo = Integer.parseInt(tuloskentta.getText());
        sovellus.plus(this.arvo);
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
