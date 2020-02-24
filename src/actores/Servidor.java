/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

import conexion.Conexion;
import elementos.Diccionario;
import java.net.SocketException;
import redes.RedServidor;

/**
 *
 * @author ACER 53F4
 */
public class Servidor {

    public static void main(String[] args) {
        RedServidor red = new RedServidor();
        Diccionario diccionario = new Diccionario();
        Conexion conexion = new Conexion("org.sqlite.JDBC", "jdbc:sqlite:C:/sqlite3/db/diccionario.db");
        diccionario.setConexion(conexion);
        red.setDiccionario(diccionario);

        try {
            red.activar();
        } catch (SocketException ex) {
            System.out.println("SERVIDOR: no pude iniciar mis servivios" + ex);
        }
    }
    
}
