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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.clases.Musica;
import magesft.clases.Usuario;
import magesft.comprar.Comprar;
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
public class TestComprar {
    
    public TestComprar() {
    }
    
    @BeforeClass
    public static void Crear_usuarioComprador() {
        Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", 0, 0);
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
            if (!(boolean) in.readObject()) {
                Integer.parseInt("ya existe");
            }
        } catch (Exception ex) {
            try {
                so = new Sockets();
                in = so.getIn();
                out = so.getOut();
                
                
                System.out.println(in.readObject());
                out.writeObject(3);
                out.writeObject("usuariocancion");
                out.writeObject(" Usuario='" + u.getUsuario() + "'");
                if((boolean)in.readObject()){
                    System.out.println("todo bien");
                }
            } catch (Exception ex1) {
                
            }
            

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
    public void Comprar_bien() {
        Sockets so = new Sockets();
            ObjectInputStream in = so.getIn();
            ObjectOutputStream out = so.getOut();

            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", 0, 0);
            Musica c=new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", "4");
                try {
                    String[] campos = {"Cancion", "Usuario"};
                    String [] insertar = {c.getIden(),u.getUsuario()};
                    System.out.println(in.readObject());
                    out.writeObject(0);
                    out.writeObject("usuariocancion");
                    out.writeObject(campos);
                    out.writeObject(insertar);
                    if(!(boolean)in.readObject()){
                        assertTrue(false);
                    }

                } catch (Exception ex) {
                    assertTrue(false);
                } 
    }
        @Test
    public void Comprar_mal() {
        Sockets so = new Sockets();
            ObjectInputStream in = so.getIn();
            ObjectOutputStream out = so.getOut();

            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", 0, 0);
            Musica c=new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", "4");
                try {
                    String[] campos = {"Cancion", "Usuario"};
                    String [] insertar = {c.getIden(),u.getUsuario()};
                    System.out.println(in.readObject());
                    out.writeObject(0);
                    out.writeObject("usuariocancion");
                    out.writeObject(campos);
                    out.writeObject(insertar);
                    if((boolean)in.readObject()){
                        assertTrue(false);
                    }

                } catch (Exception ex) {
                    assertTrue(false);
                } 
    }
}
