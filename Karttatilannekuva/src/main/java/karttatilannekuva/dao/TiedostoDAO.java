/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karttatilannekuva.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author inkilaio
 */
public class TiedostoDAO {
    
    public Integer luoTiedosto(String tiedostoNimi){
        boolean tiedostoOlemassa = onOlemassa(tiedostoNimi);
        
        if(tiedostoOlemassa){
            return 1;
        } else{
            try {
                Connection db = DriverManager.getConnection("jdbc:sqlite:" + tiedostoNimi + ".db");
                db.createStatement().execute("CREATE TABLE Pisteet (id INTEGER PRIMARY KEY AUTOINCREMENT, x INTEGER, y INTEGER, z INTEGER);");
                return 2;
            } catch (SQLException e){
                e.printStackTrace();
                return 3;
            }
        }
    }
    
    public boolean onOlemassa(String tiedostoNimi){
        try {
            Class.forName("org.sqlite.JDBC");
            String check = tiedostoNimi + ".db";
            File tiedosto = new File(check);
            return tiedosto.exists();
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    
}
