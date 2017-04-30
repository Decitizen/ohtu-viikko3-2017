
package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private Sovelluslogiikka sovellus;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, 
            JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        
    }

    @Override
    public void suorita() {
        tuloskentta.setText("");
        sovellus.setTulos(0);
    }

    @Override
    public void peru() {
        tuloskentta.setText("");
        sovellus.setTulos(0);
    }
    
}
