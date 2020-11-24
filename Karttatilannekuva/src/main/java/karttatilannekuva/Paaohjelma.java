/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva;

import karttatilannekuva.dao.TiedostoDAO;
import karttatilannekuva.dao.TietokantaDAO;
import karttatilannekuva.io.InputIO;
import karttatilannekuva.io.PisteIO;
import karttatilannekuva.domain.*;

import java.util.ArrayList;
import java.io.*;
import karttatilannekuva.domain.*;
/**
 *
 * @author inkilaio
 */
public class Paaohjelma {
    private static final String DB_TIEDOSTONIMI="kartta";
    
    public static void main(String[] args){
        System.out.println("Syötä pisteitä komennolla 1, listaa pisteet komennolla 2");
        run();
    }
    
    public static void run(){
        TiedostoDAO dbFile = new TiedostoDAO();
        dbFile.luoTiedosto(DB_TIEDOSTONIMI);
        TietokantaDAO db = new TietokantaDAO(DB_TIEDOSTONIMI);
        
        InputIO io = new InputIO(new PisteIO(db));
        io.tulostaOhjeet();
        
        while(true){
            System.out.println("\nAnna syöte:");
            String[] input = io.readInput().split(" ");
            if(input[0].equals("")){
                break;
            } else{
                io.manageInput(input);
            }
        }
    }
    
}
