/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER 53F4
 */
public class Termino {
    
    private String name;
    private String description;
    private Conexion conexion;
    
    public Termino(Conexion conexion){
        this.conexion = conexion;
    }
    
    public Termino(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Termino getTerminoDb(String name){
        Connection con = this.conexion.getCon();
        try {
            Statement st = con.createStatement();
            String sql1 ="SELECT * FROM Terminos WHERE name = '" + name.trim() + "'";
            System.out.println(sql1);
            ResultSet rs= st.executeQuery(sql1);
            
            while (rs.next()){
                return new Termino(rs.getString("name"), rs.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Termino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
