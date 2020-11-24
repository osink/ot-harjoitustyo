/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.io;

import karttatilannekuva.domain.Piste;
import java.util.HashMap;

/**
 *
 * @author inkilaio
 */
public interface MediaInterface {
    void add(Piste piste);
    
    HashMap<Integer, Piste> fetch();
    
    Piste newTip(InputInterface inputIO);
}
