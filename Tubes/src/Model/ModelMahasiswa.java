/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author R O G
 */

public class ModelMahasiswa extends Human{
    private String nim;
    private ArrayList<ModelMatkul> listMatKul;
        
    public ModelMahasiswa(String nim, String nama) {
        super(nama);
        this.nim = nim;
        listMatKul = new ArrayList();
    }    

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void addJadwal(String id_jadwal, int i, Database db){
        try {
            db.connect();
            String sql = "INSERT INTO enroll values ("+i+",'"+id_jadwal+"','"+nim+"')";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void addMatkul(String id_jadwal, Database db) {
        try {
            db.connect();
            String sql = "SELECT kode_mk, nama_mk, sks, nid FROM jadwal"
                + " natural join mata_kuliah"
                + " where id_jadwal = '" +id_jadwal+"'";
            db.setRs(db.getStmt().executeQuery(sql));
            while (db.getRs().next()) {
                ModelMatkul m = new ModelMatkul(
                    db.getRs().getString("kode_MK"),
                    db.getRs().getString("nama_MK"),
                    db.getRs().getString("SKS"),
                    db.getRs().getString("nid"),
                    db
                );
            listMatKul.add(m);
        }
        db.disconnect();
        } catch (SQLException ex) {
        Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMhs(Database db) {
        try {
            db.connect();
            String sql = "INSERT INTO mahasiswa VALUES ('"
                    +nim+"','"
                    +super.getNama()+"')";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }      
}  
    
