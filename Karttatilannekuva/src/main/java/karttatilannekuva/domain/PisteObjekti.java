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
    
    public PisteObjekti(int x, int y, int z) {
        this.sijainti = new Piste(x, y, z);
    }
    
    public PisteObjekti(int x, int y, int z, String nimi) {
        this.sijainti = new Piste(x, y, z);
        this.nimi = nimi;
    }
    
    public boolean siirra(int x, int y, int z) {
        this.sijainti.siirra(x, y, z);
        return true;
    }
    
    public boolean nimea(String nimi) {
        this.nimi = nimi;
        return true;
    }
    
    public Piste getSijainti() {
        return this.sijainti;
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
