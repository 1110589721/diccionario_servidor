/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ACER 53F4
 */
public class Conexion {
    private String controlador;
    private String cadenaConex;
    private Connection con;

    public Conexion(String controlador, String cadenaConex) {
        try {
            this.controlador = controlador;
            this.cadenaConex = cadenaConex;
 
            Class.forName(controlador);
            
            this.con = DriverManager.getConnection(this.cadenaConex);
 
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }
    
}
