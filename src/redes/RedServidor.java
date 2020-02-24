/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes;

import elementos.Diccionario;
import elementos.Termino;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER 53F4
 */
public class RedServidor {
    private DatagramSocket socket = null;
    private int port;
    private Diccionario diccionario;
    private InetAddress destinatarioIp;
    private int destinatarioPuerto;
    
    public RedServidor(){
        port = 4400;
    }
    
    public void activar() throws SocketException{
        socket = new DatagramSocket(port);
        procesar();
    }
    
    private void procesar(){
        while(true){
            byte[] mensaje;
            try{
                mensaje = recibirMensaje();
                Termino termino = diccionario.buscarTermino(new String(mensaje));
                byte[] respuesta = new String(termino.getDescription()).getBytes();
                enviarMensaje(respuesta, destinatarioIp, destinatarioPuerto);
            }catch(IOException ex){
               Logger.getLogger(RedServidor.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    
    public void desactivar(){
        socket.close();
    }
    
    public void enviarMensaje(byte[] mensaje, InetAddress destinatario, int puerto) throws UnknownHostException, IOException{
        byte[] hoja = new String(mensaje).getBytes();	

        DatagramPacket sobre = new DatagramPacket(hoja, hoja.length, destinatario, puerto);		
			
        socket.send(sobre);		 
    }
    
    public byte[] recibirMensaje()throws IOException{
        byte[] hoja = new byte[1000];		

        DatagramPacket sobre = new DatagramPacket(hoja, hoja.length);
        
        socket.receive(sobre);
        
        destinatarioIp = sobre.getAddress();
        destinatarioPuerto = sobre.getPort();
        
        return sobre.getData();
    }
    
    public void setDiccionario(Diccionario diccionario){
        this.diccionario = diccionario;
    }
 
}
