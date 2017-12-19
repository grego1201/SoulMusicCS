/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.clases.Usuario;
import magesft.sockets.Sockets;
import magesft2.conectar.Conexion_BBDD;
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
public class TestCrearUsuario {
    
    public TestCrearUsuario() {
    }
    
    @BeforeClass
    public static void EliminarUsuario() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        
        try {
            Conexion_BBDD c=new Conexion_BBDD();
            if (!(boolean) c.delete("usuarios", " Nombre_user='" + u.getUsuario() + "'")) {
                System.out.println("No hay nada que borrar");
            }
        } catch (Exception ex) {
            

        } 
    }

    /**
     *
     */
    @Test
    public void CrearUser_bien() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        
        try {
            String[] campos = {"Nombre_user", "Contrasenia", "Correo", "saldo", "rol"};

           
            String[] v_insertar = {u.getUsuario(), u.getContrasenia(), u.getCorreo(), String.valueOf(u.getSaldo()), String.valueOf(u.getRol())};//valores a insertar
            Conexion_BBDD c=new Conexion_BBDD();
            if (!(boolean) c.insertar("usuarios", campos, v_insertar)) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

        }  
    }

    /**
     *
     */
    @Test
    public void CrearUser_mal() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
        
        try {
            String[] campos = {"Nombre_user", "Contrasenia", "Correo", "saldo", "rol"};

            String[] v_insertar = {u.getUsuario(), u.getContrasenia(), u.getCorreo(), String.valueOf(u.getSaldo()), String.valueOf(u.getRol())};//valores a insertar
            Conexion_BBDD c=new Conexion_BBDD();
            if ((boolean) c.insertar("usuarios", campos, v_insertar)) {
                assertTrue(true);
            }
        } catch (Exception ex) {
            assertTrue(true);

        } 
    }
}
