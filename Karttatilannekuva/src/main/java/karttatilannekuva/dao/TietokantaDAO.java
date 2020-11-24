/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.dao;

import karttatilannekuva.domain.Piste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inkilaio
 */
import java.util.logging.Level;
import java.util.logging.Logger;
public class TietokantaDAO {
    
    String kanta;
    
    public TietokantaDAO(String kanta) {
        this.kanta = kanta;
    }
    
    public Connection luoYhteys() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection yhteys = DriverManager.getConnection("jdbc:sqlite:" + kanta + ".db");
            return yhteys;
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(TietokantaDAO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public boolean lisaaPiste(int x, int y, int z) {
        try {
            Connection dM = luoYhteys();
            PreparedStatement p = dM.prepareStatement("INSERT INTO Pisteet(x, y, z) VALUES (?, ?, ?)");
            p.setInt(1, x);
            p.setInt(2, y);
            p.setInt(3, z);
            p.executeUpdate();
            dM.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public HashMap<Integer, Piste> listaaPisteet() {
        try {
            Connection dM = luoYhteys();
            PreparedStatement p;
            p = dM.prepareStatement("SELECT * FROM Pisteet");
            ResultSet r = p.executeQuery();
            HashMap<Integer, Piste> pisteet = new HashMap<>();
            while (r.next()) {
                pisteet.put(r.getInt("id"), new Piste(r.getInt("x"), r.getInt("y"), r.getInt("z")));
            }
            dM.close();
            return pisteet;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
