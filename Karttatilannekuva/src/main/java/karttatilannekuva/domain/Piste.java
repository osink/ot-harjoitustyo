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
public class Piste {
    private int koordX;
    private int koordY;
    
    public Piste(int x, int y){
        if(x >= 0){
            this.koordX = x;
        }else{
            this.koordX = 0;
        }
        if(y >= 0){
            this.koordY = y;
        }else{
            this.koordY = 0;
        }
    }
    
    public boolean siirra(int x,int y){
        boolean virhe = true;
        if(x >= 0){
            this.koordX = x;
        }else{
            this.koordX = 0;
            virhe = false;
        }
        if(y >= 0){
            this.koordY = y;
        }else{
            this.koordY = 0;
            virhe = false;
        }
        return virhe;
    }
    
    public int getX(){
        return this.koordX;
    }
    
    public int getY(){
        return this.koordY;
    }
}
