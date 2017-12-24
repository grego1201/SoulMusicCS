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
public class TestLoginUsuario {
    
    public TestLoginUsuario() {
    }
    
    @Before
    public void CrearUser_bien() {
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
            if (!(boolean) in.readObject()) {
                System.out.println("ya esta creado");
            }
        } catch (Exception ex) {

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
    @Before
    public void EliminarUsuario() {
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
                System.out.println("No hay nada que borrar");
            }
        } catch (IOException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
    public void Logearse_bien() {
        try {
            Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
            Sockets so=new Sockets();
            ObjectOutputStream out=so.getOut();
            ObjectInputStream in=so.getIn();
            String campos[]={"Nombre_user","Contrasenia"};
            String condicion = "WHERE Nombre_user = '" + u.getUsuario() + "' AND Contrasenia = '" + u.getContrasenia() + "'";
            
            System.out.println((String)in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject(condicion);
            if(((ArrayList<String[]>)in.readObject()).size()!=1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);
        } 
    }
    @Test
    public void Logearse_malconCONTRASENIA() {
        try {
            Usuario u = new Usuario("Gonzalo", null, "Gonzalo@gmail.com", 0, 1);
            Sockets so=new Sockets();
            ObjectOutputStream out=so.getOut();
            ObjectInputStream in=so.getIn();
            String campos[]={"Nombre_user","Contrasenia"};
            String condicion = "WHERE Nombre_user = '" + u.getUsuario() + "' AND Contrasenia = '" + u.getContrasenia() + "'";
            
            System.out.println((String)in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject(condicion);
            if(((ArrayList<String[]>)in.readObject()).size()==1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);
        } 
    } 
    @Test
    public void Logearse_mal() {
        try {
            EliminarUsuario();
            Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
            Sockets so=new Sockets();
            ObjectOutputStream out=so.getOut();
            ObjectInputStream in=so.getIn();
            String campos[]={"Nombre_user","Contrasenia"};
            String condicion = "WHERE Nombre_user = '" + u.getUsuario() + "' AND Contrasenia = '" + u.getContrasenia() + "'";
            
            System.out.println((String)in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject(condicion);
            if(((ArrayList<String[]>)in.readObject()).size()==1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);
        } 
    }
    @Test
    public void Logearse_mal2() {
        try {
            EliminarUsuario();
            Usuario u = new Usuario(null, "Gonzalo", "Gonzalo@gmail.com", 0, 1);
            Sockets so=new Sockets();
            ObjectOutputStream out=so.getOut();
            ObjectInputStream in=so.getIn();
            String campos[]={"Nombre_user","Contrasenia"};
            String condicion = "WHERE Nombre_user = '" + u.getUsuario() + "' AND Contrasenia = '" + u.getContrasenia() + "'";
            
            System.out.println((String)in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject(condicion);
            if(((ArrayList<String[]>)in.readObject()).size()==1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);
        } 
    }
    @Test
    public void Logearse_mal3() {
        try {
            EliminarUsuario();
            Usuario u = new Usuario(null, null, "Gonzalo@gmail.com", 0, 1);
            Sockets so=new Sockets();
            ObjectOutputStream out=so.getOut();
            ObjectInputStream in=so.getIn();
            String campos[]={"Nombre_user","Contrasenia"};
            String condicion = "WHERE Nombre_user = '" + u.getUsuario() + "' AND Contrasenia = '" + u.getContrasenia() + "'";
            
            System.out.println((String)in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject(condicion);
            if(((ArrayList<String[]>)in.readObject()).size()==1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);
        } 
    }
}
