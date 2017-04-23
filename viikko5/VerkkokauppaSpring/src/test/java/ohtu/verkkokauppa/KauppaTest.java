/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Willburner
 */
public class KauppaTest {
    
    Kauppa kauppa;
    Varasto varasto;
    Pankki pankki;
    Viitegeneraattori viitegeneraattori;

    @Before
    public void setUp() {
        this.varasto = mock(Varasto.class);
        this.viitegeneraattori = mock(Viitegeneraattori.class);
        this.pankki = mock(Pankki.class);
        this.kauppa = new Kauppa(varasto, pankki, viitegeneraattori);
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);    
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);

        verify(pankki).tilisiirto(ostaja, 42, tilinumero, "33333-44455", 5);
    }
    
    @Test
    public void pankinTilisiirtoaKutsutaanKunKaksieriOstosta() {
        when(viitegeneraattori.uusi()).thenReturn(35);        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(3)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "puujalka", 25));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);    
        kauppa.lisaaKoriin(3);    
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);

        verify(pankki).tilisiirto(ostaja, 35, tilinumero, "33333-44455", 30);
    }
    
    @Test
    public void pankinTilisiirtoaKutsutaanKunKaksiSamaaOstosta() {
        when(viitegeneraattori.uusi()).thenReturn(35);        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(9);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);      
        kauppa.lisaaKoriin(1);         
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);

        verify(pankki).tilisiirto(ostaja, 35, tilinumero, "33333-44455", 10);
    }
    
    @Test
    public void pankinTilisiirtoaKutsutaanKunToinenTuoteLoppu() {
        when(viitegeneraattori.uusi()).thenReturn(35);        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "puujalka", 25));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);      
        kauppa.lisaaKoriin(3);         
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);

        verify(pankki).tilisiirto(ostaja, 35, tilinumero, "33333-44455", 5);
    }
    
    @Test
    public void testAloitaAsiointiNollaaAiemmatOstokset() {
        when(viitegeneraattori.uusi()).thenReturn(35);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(1)).thenReturn(9);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);
        
        verify(pankki).tilisiirto(ostaja, 35, tilinumero, "33333-44455", 5);
    }

    @Test
    public void testUusiViitenumeroEdellisenOstoksenJalkeen() {
        when(viitegeneraattori.uusi()).thenReturn(42);
        
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);    
        String ostaja = "pekka";
        String tilinumero = "22222";
        kauppa.tilimaksu(ostaja, tilinumero);
        
        verify(viitegeneraattori).uusi();
    }
    
    @Test
    public void metodiPoistaKoristaKutsuuVarastonPalautaVarastoonMetodia() {
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.poistaKorista(1);
        
        verify(varasto).palautaVarastoon(new Tuote(1, "maito", 5));
    }
}
