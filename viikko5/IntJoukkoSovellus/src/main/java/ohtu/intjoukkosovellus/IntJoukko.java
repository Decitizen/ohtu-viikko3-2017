
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; 
    public final static int OLETUSKASVATUS = 5;  
    private int kasvatuskoko;     
    private int[] luvut;      
    private int alkioidenLkm;     
    
    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti >= 0 && kasvatuskoko >= 0) {
            luvut = new int[kapasiteetti];
            for (int i = 0; i < luvut.length; i++) {
                luvut[i] = 0;
            }
            alkioidenLkm = 0;
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            luvut[0] = luku;
            alkioidenLkm++;
            return true;
        } 
        if (!kuuluu(luku)) {
            kasvataTaulukkoa(luku);
            return true;
        }
        return false;
    }

    public void kasvataTaulukkoa(int luku) {
        luvut[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % luvut.length == 0) {
            int[] taulukkoOld = new int[luvut.length];
            taulukkoOld = luvut;
            kopioiTaulukko(luvut, taulukkoOld);
            luvut = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, luvut);
        }
    }

    public boolean kuuluu(int luku) {
        int kuuluuLkm = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                kuuluuLkm++;
            }
        }
        return (kuuluuLkm > 0);
    }

    public boolean poista(int luku) {
        int luvunIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                luvunIndeksi = i; 
                luvut[luvunIndeksi] = 0;
                break;
            }
        }
        if (luvunIndeksi != -1) {
            for (int j = luvunIndeksi; j < alkioidenLkm - 1; j++) {
                int vaihto = luvut[j];
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = vaihto;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvut[0] + "}";
        } else {
            return tulostaAlkiot();
        }
    }

    public String tulostaAlkiot() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += luvut[i];
            tuotos += ", ";
        }
        tuotos += luvut[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko aJoukko, IntJoukko bJoukko) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulu = aJoukko.toIntArray();
        int[] bTaulu = bJoukko.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko aJoukko, IntJoukko bJoukko) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulukko = aJoukko.toIntArray();
        int[] bTaulukko = bJoukko.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            for (int j = 0; j < bTaulukko.length; j++) {
                if (aTaulukko[i] == bTaulukko[j]) {
                    leikkausJoukko.lisaa(bTaulukko[j]);
                }
            }
        }
        return leikkausJoukko;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(i);
        }
        return erotusJoukko;
    }
}