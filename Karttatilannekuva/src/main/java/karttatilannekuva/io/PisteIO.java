/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.io;

import karttatilannekuva.domain.*;
import karttatilannekuva.dao.*;
import java.util.HashMap;

/**
 *
 * @author inkilaio
 */
public class PisteIO implements MediaInterface {
    TietokantaDAO db;
    
    public PisteIO(TietokantaDAO db){
        this.db = db;
    }
    
    /** Noutaa muistissa olevat pisteet
     * 
     * @return taulu id : Piste
     */
    @Override
    public HashMap<Integer, Piste> fetch(){
        HashMap<Integer, Piste> pisteet = db.listaaPisteet();
        return pisteet;
    }
    
    @Override
    public Piste NewTip(InputInterface inputIO) {
        inputIO.println("Lisätään uusi piste");
        inputIO.println("Anna pisteen x: ");
        int x = Integer.valueOf(inputIO.readInput());
        inputIO.println("Anna pisteen y: ");
        int y = Integer.valueOf(inputIO.readInput());
        inputIO.println("Anna pisteen z: ");
        int z = Integer.valueOf(inputIO.readInput());
        Piste piste = new Piste(x, y, z);
        return piste;
    }
    
    @Override
    public void add(Piste piste){
        db.lisaaPiste(piste.getX(), piste.getY(), piste.getZ());
    }
}
