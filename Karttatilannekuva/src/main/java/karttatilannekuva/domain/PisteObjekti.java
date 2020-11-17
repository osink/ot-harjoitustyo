/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.domain;

/**
 *
 * @author inkilaio
 */
public class PisteObjekti {
    private Piste sijainti;
    private String nimi;
    
    public PisteObjekti(int x, int y){
        this.sijainti = new Piste(x,y);
    }
    
    public PisteObjekti(int x, int y, String nimi){
        this.sijainti = new Piste(x,y);
        this.nimi = nimi;
    }
    
    public boolean siirra(int x, int y){
        this.sijainti.siirra(x, y);
        return true;
    }
    
    public boolean nimea(String nimi){
        this.nimi = nimi;
        return true;
    }
    
    public Piste getSijainti(){
        return this.sijainti;
    }
    
    public String getNimi(){
        return this.nimi;
    }
}
