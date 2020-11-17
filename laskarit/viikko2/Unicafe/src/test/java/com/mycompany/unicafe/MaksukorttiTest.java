package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein(){
        assertEquals(10,kortti.saldo());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoa(){
        kortti.lataaRahaa(20);
        assertEquals(30,kortti.saldo());
    }
    
    @Test
    public void otaRahaaToimii(){
        kortti.otaRahaa(5);
        assertEquals(5,kortti.saldo());
    }
    
    @Test
    public void rahaaEiVoiOttaaLiikaa(){
        kortti.otaRahaa(70);
        assertEquals(10,kortti.saldo());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosSaldoRiittaa(){
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahaEiRiita(){
        assertTrue(!kortti.otaRahaa(70));
    }
    
    @Test
    public void tulostusToimii(){
        assertEquals("saldo: 0.10",kortti.toString());
    }
}
