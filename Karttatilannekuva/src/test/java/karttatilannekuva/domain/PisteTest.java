package karttatilannekuva.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PisteTest {
    Piste piste;
    
    public PisteTest() {
    }
    @Before
    public void setUp() {
        piste = new Piste(2,3,11);
    }
    
    @Test
    public void pisteKonstruktoriXOikein(){
        assertEquals(2,piste.getX());
    }
    
    @Test
    public void pisteKonstruktoriYOikein(){
        assertEquals(3,piste.getY());
    }
    
    @Test
    public void pisteKonstruktoriZOikein(){
        assertEquals(11,piste.getZ());
    }
    
    
    @Test
    public void pisteKonstruktoriEiVoiOllaNegatiivinenX(){
        piste = new Piste(-2,2,2);
        assertEquals(0,piste.getX());
    }
    
    @Test
    public void pisteKonstruktoriEiVoiOllaNegatiivinenY(){
        piste = new Piste(2,-2,2);
        assertEquals(0,piste.getY());
    }
    
    @Test
    public void pisteKonstruktoriEiVoiOllaNegatiivinenZ(){
        piste = new Piste(2,2,-2);
        assertEquals(0,piste.getZ());
    }
    
    @Test
    public void tulostusOikein(){
        assertEquals("x: 2\ty: 3\tz: 11", piste.toString());
    }
    
    @Test
    public void siirtoToimii(){
        piste.siirra(11, 2, 1);
        assertEquals("x: 11\ty: 2\tz: 1", piste.toString());
    }
    
    @Test
    public void siirtoToimiiNegatiiviset(){
        piste.siirra(-4, -1, -11);
        assertEquals("x: 0\ty: 0\tz: 0", piste.toString());
    }
}
