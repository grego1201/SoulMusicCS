/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.clases.Usuario;
import magesft.crearusuario.CrearUsuario;
import magesft.sockets.Sockets;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gonzalo
 */
public class TestEliminarUsuario {
    /*ANOTAACION IMPORTANTE:
        SI TENEMOS UN USUARIO QUE TIENE CANCIONES COMPRADAS NO VAMOS A PODER ELIMINAR ESE USUARIO POR NUESTRO CODIGO
    LO CUAL TENDREMOS QUE SOLUCIONAR EN MANTENIMIENTO*/
    public TestEliminarUsuario() {
    }
    
   @Before
    public void CrearUser() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {
            String[] campos = {"Nombre_user", "Contrasenia", "Correo", "saldo", "rol"};

            String recibido = (String) in.readObject();
            System.out.println(recibido);

            out.writeObject(0);//opcion insertar
            out.writeObject("usuarios"); //tabla
            out.writeObject(campos);// campos sobre los que insertar
            String[] v_insertar = {u.getUsuario(), u.getContrasenia(), u.getCorreo(), String.valueOf(u.getSaldo()), String.valueOf(u.getRol())};//valores a insertar
            out.writeObject(v_insertar);
            if ((boolean) in.readObject()) {
                System.out.println("creado");
            }
        } catch (Exception ex) {
            System.out.println("ya esta creado");

        }  finally {
            try {
                out.flush();
                out.close();
                in.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
     @Test
    public void EliminarUsuario() {
        eliminarcomprar();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {

            String recibido = (String) in.readObject();
            System.out.println(recibido);

            out.writeObject(3);//opcion eliminar
            out.writeObject("usuarios"); //tabla
            out.writeObject(" Nombre_user='" + u.getUsuario() + "'");// campos sobre los que insertar

            if (!(boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

        }  finally {
            try {
                out.flush();
                out.close();
                in.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void comprar(){
        Sockets so = new Sockets();
        String [] a={"Usuario","Cancion"};
        String [] b={"Gonzalo","1"};
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {
            in.readObject();
            out.writeObject(0);
            out.writeObject("usuariocancion");
            out.writeObject(a);
            out.writeObject(b);
            in.readObject();
        }catch(Exception ex){
            
        }
    }
      public void eliminarcomprar(){
        Sockets so = new Sockets();
        String [] a={"Usuario","Cancion"};
        String [] b={"Gonzalo","1"};
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {
            in.readObject();
            out.writeObject(3);
            out.writeObject("usuariocancion");
            out.writeObject(" Usuario='" + "Gonzalo" + "'");
            in.readObject();
        }catch(Exception ex){
            
        }
    }
    @Test
    public void EliminarUsuarioCONCOMPRA() {
        comprar();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {

            String recibido = (String) in.readObject();
            System.out.println(recibido);

            out.writeObject(3);//opcion eliminar
            out.writeObject("usuarios"); //tabla
            out.writeObject(" Nombre_user='" + u.getUsuario() + "'");// campos sobre los que insertar

            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

        }  finally {
            try {
                out.flush();
                out.close();
                in.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
