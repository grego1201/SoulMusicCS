/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.serv_func;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft2.conectar.Conexion_BBDD;

/**
 *
 * @author Gonzalo
 */
public class funcion extends Thread{
    
    public void run() {
        try {
                 funcion();
        } catch (IOException ex) {
            Logger.getLogger(funcion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(funcion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(funcion.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public void funcion() throws IOException, ClassNotFoundException, SQLException {
        ServerSocket listener = new ServerSocket(4445);
        ObjectOutputStream out=null;
        ObjectInputStream in=null;
        Socket socket=null;
        System.out.println("escuchando en el puerto 4445");
        try {
            while (true) {
                socket = listener.accept();
                try {
                    
                    out = new ObjectOutputStream(socket.getOutputStream());

                    out.writeObject("Conexion establecida");
                    
                    in = new ObjectInputStream(socket.getInputStream());
                    
                    switch((int)in.readObject()){
                        case 0: insertar(in); break; 
                        case 1: consulta(in,out); break;
                        case 2: modificar(in); break;
                        case 3: eliminar(in); break;
                    }

                } finally {
                    
                }
            }
        } finally {
            out.flush();
            out.close();
            in.close();
            socket.close();
            listener.close();
        }
    }

    public void insertar(ObjectInputStream in) throws IOException, ClassNotFoundException, SQLException {
        
        String tabla = (String) in.readObject();
        String[] valores = (String[]) in.readObject();
        String[] v_insertar = (String[]) in.readObject();
        Conexion_BBDD c = new Conexion_BBDD();
        c.insertar(tabla, valores, v_insertar);
        
    }
    
    public void modificar(ObjectInputStream in) throws IOException, ClassNotFoundException, SQLException {
        
        String tabla = (String) in.readObject();
        String[] valores = (String[]) in.readObject();
        String[] v_insertar = (String[]) in.readObject();
        String condicion = (String) in.readObject();
        Conexion_BBDD c = new Conexion_BBDD();
        c.update(tabla, valores, v_insertar,condicion);
        
    }
    
    public void consulta(ObjectInputStream in, ObjectOutputStream out) throws IOException, ClassNotFoundException, SQLException {
        
        String tabla = (String) in.readObject();
        String [] campos = (String[]) in.readObject();
        String condicion = (String) in.readObject();
        Conexion_BBDD c = new Conexion_BBDD();
        out.writeObject(c.consulta(tabla, campos, condicion));
        
    }
    
    public void eliminar(ObjectInputStream in) throws IOException, ClassNotFoundException, SQLException {
        
        String tabla = (String) in.readObject();
        String condicion = (String) in.readObject();
        Conexion_BBDD c = new Conexion_BBDD();
        c.delete(tabla,condicion);
        
    }
    
}
