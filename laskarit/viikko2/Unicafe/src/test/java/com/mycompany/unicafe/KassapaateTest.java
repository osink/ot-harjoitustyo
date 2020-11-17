/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inkilaio
 */
public class KassapaateTest {
    
    public KassapaateTest() {
    }
    
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti2 = new Maksukortti(10);
    }
    
    @Test
    public void uusiKassaOikeaRahamaara(){
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void uudessaKassassaEiMyytyjaEdullisia(){
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void uudessaKassassaEiMyytyjaMaukkaita(){
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassaOttaaEdullisenKateisOston(){
        kassa.syoEdullisesti(400);
        assertEquals(100240,kassa.kassassaRahaa());
    }
    
    @Test
    public void kassaOttaaMaukkaanKateisOston(){
        kassa.syoMaukkaasti(400);
        assertEquals(100400,kassa.kassassaRahaa());
    }
    
    @Test
    public void oikeaVaihtorahaEdullinen(){
        assertEquals(160,kassa.syoEdullisesti(400));
    }
    
    @Test
    public void oikeaVaihtorahaMaukas(){
        assertEquals(600,kassa.syoMaukkaasti(1000));
    }
    
    @Test
    public void edullisetMyydytKasvaa(){
        kassa.syoEdullisesti(400);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaatMyydytKasvaa(){
        kassa.syoMaukkaasti(400);
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahaEiKasvaLiianHalvallaEdullinen(){
        kassa.syoEdullisesti(200);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void rahaEiKasvaLiianHalvallaMaukas(){
        kassa.syoMaukkaasti(200);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void kaikkiTakaisinJosRahaEiRiitaEdullinen(){
        assertEquals(200,kassa.syoEdullisesti(200));
    }
    
    @Test
    public void kaikkiTakaisinJosRahaEiRiitaMaukas(){
        assertEquals(200,kassa.syoMaukkaasti(200));
    }
    
    @Test
    public void myydytEiLisaannyJosRahaEiRiitaEdullinen(){
        kassa.syoEdullisesti(200);
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytEiLisaannyJosRahaEiRiitaMaukas(){
        kassa.syoMaukkaasti(200);
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortiltaVeloitetaanEdullinen(){
        kassa.syoEdullisesti(kortti);
        assertEquals(760,kortti.saldo());
    }
    
    @Test
    public void kortiltaVeloitetaanMaukas(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(600,kortti.saldo());
    }
    
    @Test
    public void kortiltaVeloitetaanEdullinenPalauttaaTrue(){
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void kortiltaVeloitetaanMaukasPalauttaaTrue(){
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kortiltaVeloitetaanEdullinenMaaraKasvaa(){
        kassa.syoEdullisesti(kortti);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kortiltaVeloitetaanMaukasMaaraKasvaa(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void koyhaltaKortiltaSaldoEiVaheneEdullinen(){
        kassa.syoEdullisesti(kortti2);
        assertEquals(10,kortti2.saldo());
    }
    
    @Test
    public void koyhaltaKortiltaSaldoEiVaheneMaukas(){
        kassa.syoMaukkaasti(kortti2);
        assertEquals(10,kortti2.saldo());
    }
    
    @Test
    public void koyhaltaKortiltaMyydytEiKasvaEdullinen(){
        kassa.syoEdullisesti(kortti2);
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void koyhaltaKortiltaMyydytEiKasvaMaukas(){
        kassa.syoMaukkaasti(kortti2);
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void koyhaltaKortiltaMyydytPalauttaaFalseEdullinen(){
        assertTrue(!kassa.syoEdullisesti(kortti2));
    }
    
    @Test
    public void koyhaltaKortiltaMyydytPalauttaaFalseMaukas(){
        assertTrue(!kassa.syoMaukkaasti(kortti2));
    }
    
    @Test
    public void kassaEiMuutuKortillaEdullinen(){
        kassa.syoEdullisesti(kortti);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void kassaEiMuutuKortillaMaukas(){
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void latausKasvattaaKassa(){
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000,kassa.kassassaRahaa());
    }
    
    @Test
    public void latausKasvattaaKortinSaldoa(){
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000,kortti.saldo());
    }
    
    @Test
    public void negatiivinenLatausEiOnnistu(){
        kassa.lataaRahaaKortille(kortti, -1000);
        assertEquals(1000,kortti.saldo());
    }
    
}
