/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import Controller.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author R O G
 */
public class ModelAdmin {   
    
    public void addJadwal(String id_jadwal, String kode_mk, String no_ruangan, String waktu, Database db) {
        try {
            db.connect();
            String sql = "INSERT INTO jadwal VALUES ('"
                    +id_jadwal+"','"
                    +kode_mk+"','"
                    +no_ruangan+"','"
                    +waktu+"')";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteJadwal(String id_jadwal, Database db) {
        try{
            db.connect();
            String sql = "DELETE FROM jadwal WHERE id_jadwal = '" + id_jadwal +"'";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
