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
        piste = new Piste(2,3,0);
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
    public void pisteKonstruktoriEiVoiOllaNegatiivinenX(){
        piste = new Piste(-2,2,2);
        assertEquals(0,piste.getX());
    }
    
    @Test
    public void pisteKonstruktoriEiVoiOllaNegatiivinenY(){
        piste = new Piste(2,-2,2);
        assertEquals(0,piste.getY());
    }
    
}
