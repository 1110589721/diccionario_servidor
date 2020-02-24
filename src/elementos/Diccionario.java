/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author ACER 53F4
 */
public class Diccionario {
    private ArrayList<Termino> terminos;
    private Conexion conexion;
    
    public Diccionario(){
        
    }
    
    public Termino buscarTermino(String name){
        Termino termino = new Termino(this.conexion);
        Termino terminoDb = termino.getTerminoDb(name);
        return terminoDb;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
}
