
package ohtu.kivipaperisakset;

public class IhmisPelaaja implements Pelaaja {
    private IO io;

    public IhmisPelaaja(IO io) {
        this.io = io;
    }
    
    @Override
    public SiirtoTyyppi annaSiirto() {
        
    }

    @Override
    public void asetaSiirto(SiirtoTyyppi ekanSiirto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
