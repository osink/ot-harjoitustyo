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
    private int koordZ;
    
    public Piste(int x, int y, int z) {
        if (x >= 0) {
            this.koordX = x;
        } else {
            this.koordX = 0;
        }
        if (y >= 0) {
            this.koordY = y;
        } else {
            this.koordY = 0;
        }
        if (z >= 0) {
            this.koordZ = z;
        } else {
            this.koordZ = 0;
        }
    }
    
    public boolean siirra(int x,  int y, int z) {
        boolean virhe = true;
        if (x < 0) {
            x = 0;
            virhe = false;
        }
        if (y < 0) {
            y = 0;
            virhe = false;
        }
        if (z < 0) {
            z = 0;
            virhe = false;
        }
        this.koordX = x;
        this.koordY = y;
        this.koordZ = z;
        return virhe;
    }
    
    public int getX() {
        return this.koordX;
    }
    
    public int getY() {
        return this.koordY;
    }    
    
    public int getZ() {
        return this.koordZ;
    }
    
    @Override
    public String toString() {
        return "x: " + this.koordX + "\ty: " + this.koordY + "\tz: " + this.koordZ;
    }
}
