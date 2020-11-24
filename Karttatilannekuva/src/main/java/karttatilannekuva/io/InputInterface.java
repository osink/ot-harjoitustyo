/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.io;

/**
 *
 * @author inkilaio
 */
public interface InputInterface {
    void manageInput(String[] input);
    
    String readInput();
    
    void println(String text);    
}
