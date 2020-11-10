package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollisavi
 */
public class KassapaateTest {

    Kassapaate k;

    @Before
    public void setUp() {
        k = new Kassapaate();
    }
    
    @Test
    public void luoKassapaateTarkastaRahamaara() {
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void luoKassapaateTarkastaEdullisetLounaat() {
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void luoKassapaateTarkastaMaukkaatLounaat() {
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuRiittavaVaihtorahaOikein() {
        assertEquals(60,k.syoEdullisesti(300));                
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuRiittavaRahamaaraKasvaa() {
        k.syoEdullisesti(240);
        assertEquals(100240, k.kassassaRahaa());
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuRiittavaLounasmaaraKasvaa() {
        k.syoEdullisesti(240);
        assertEquals(1, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuRiittavaVaihtorahaOikein() {
        assertEquals(100,k.syoMaukkaasti(500));                
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuRiittavaRahamaaraKasvaa() {
        k.syoMaukkaasti(400);
        assertEquals(100400, k.kassassaRahaa());
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuRiittavaLounasmaaraKasvaa() {
        k.syoMaukkaasti(400);
        assertEquals(1, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuEiRiittavaVaihtorahaOikein() {
        assertEquals(230,k.syoEdullisesti(230));                
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuEiRiittavaRahamaaraEiKasva() {
        k.syoEdullisesti(230);
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void syoKateisellaEdullisestiMaksuEiRiittavaLounasmaaraEiKasva() {
        k.syoEdullisesti(230);
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuEiRiittavaVaihtorahaOikein() {
        assertEquals(350,k.syoMaukkaasti(350));                
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuEiRiittavaRahamaaraEiKasva() {
        k.syoMaukkaasti(350);
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void syoKateisellaMaukkaastiMaksuEiRiittavaLounasmaaraEiKasva() {
        k.syoMaukkaasti(350);
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoKortillaEdullisestiKortillaRiittavastiRahaa() {
        Maksukortti m = new Maksukortti(1000);
        assertTrue(k.syoEdullisesti(m));
        assertEquals(760, m.saldo());
    }
    
    @Test
    public void syoKortillaEdullisestiKortillaRiittavastiRahaaLounasmaaraKasvaa() {
        Maksukortti m = new Maksukortti(1000);
        k.syoEdullisesti(m);
        assertEquals(1, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoKortillaMaukkaastiKortillaRiittavastiRahaa() {
        Maksukortti m = new Maksukortti(1000);
        assertTrue(k.syoMaukkaasti(m));
        assertEquals(600, m.saldo());
    }
    
    @Test
    public void syoKortillaMaukkaastiKortillaRiittavastiRahaaLounasmaaraKasvaa() {
        Maksukortti m = new Maksukortti(1000);
        k.syoMaukkaasti(m);
        assertEquals(1, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoKortillaEdullisestiKortillaEiRiittavastiRahaa() {
        Maksukortti m = new Maksukortti(200);
        assertFalse(k.syoEdullisesti(m));
        assertEquals(200, m.saldo());
        assertEquals(0, k.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoKortillaMaukkaastiKortillaEiRiittavastiRahaa() {
        Maksukortti m = new Maksukortti(200);
        assertFalse(k.syoMaukkaasti(m));
        assertEquals(200, m.saldo());
        assertEquals(0, k.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanSaldoEiMuutuKortillaOstettaessa() {
        Maksukortti m = new Maksukortti(100000);
        k.syoMaukkaasti(m);
        k.syoEdullisesti(m);
        assertEquals(100000, k.kassassaRahaa());
    }
    
    @Test
    public void lataaKortilleRahaaKortinJaKassanSaldoKasvaa() {
        Maksukortti m = new Maksukortti(1000);
        k.lataaRahaaKortille(m, 1000);
        assertEquals(2000, m.saldo());
        assertEquals(101000, k.kassassaRahaa());
    }
    
    @Test
    public void lataaKortilleMiinusRahaaKortinJaKassanSaldoEiKasva() {
        Maksukortti m = new Maksukortti(1000);
        k.lataaRahaaKortille(m, -1000);
        assertEquals(1000, m.saldo());
        assertEquals(100000, k.kassassaRahaa());
    }

}
