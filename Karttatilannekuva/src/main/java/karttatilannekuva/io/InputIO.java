/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.io;

import karttatilannekuva.domain.*;
import karttatilannekuva.io.*;
import java.util.Scanner;
import java.util.HashMap;


/**
 *
 * @author inkilaio
 */
public class InputIO implements InputInterface {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static final String ADD = "lisaa";
    private static final String GET = "hae";

    private InputInterface inputIO;
    private MediaInterface pisteIO;
    
    public InputIO(MediaInterface pIO) {
        pisteIO = pIO;
        inputIO = this;
    }
    
    public InputIO(MediaInterface pIO, InputInterface iIO) {
        pisteIO = pIO;
        inputIO = iIO;
    }
    
    @Override public String readInput() {
        return SCANNER.nextLine();
    }
    
    @Override
    public void manageInput(String[] input) {
        if (!validateInput(input)) {
            inputIO.println("Ei hyväksyttävä syöte");
            return;
        }
        if (input[0].toLowerCase().equals(GET)) {
            HashMap<Integer, Piste> pisteet = new HashMap<>();
            pisteet = pisteIO.fetch();
            if (!pisteet.isEmpty()) {
                pisteet.forEach((id, piste) -> inputIO.println(id + ":\t" + piste.toString()));
            }
        } else if (input[0].toLowerCase().equals(ADD)) {
            Piste piste = pisteIO.newTip(inputIO);
            pisteIO.add(piste);
        } else {
            inputIO.println("Ei hyväksyttävä syöte");
        }
    }
    
    public void tulostaOhjeet() {
        inputIO.println("\nKOMENNOT:\n" + GET + " hakee pisteet\n"
                + ADD + " lisää pisteen\n"
                + "tyhjä syöte lopettaa ohjelman");
    }
    
    private static boolean validateInput(String[] input) {
        return (input.length == 1 && (input[0].toLowerCase().equals(ADD) || input[0].toLowerCase().equals(GET)));
    }
    
    @Override
    public void println(String text) {
        System.out.println(text);
    }
    
    public InputInterface getInputIO() {
        return inputIO;
    }
} 
