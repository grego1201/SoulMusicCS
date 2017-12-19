/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.servidor;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TestCrearArtista {

    public TestCrearArtista() {
    }

    @BeforeClass
    public static void borrar_siexiste() {
        try {
            String nombre = "System of a down";
            String fecha = "1988-08-09";
            Conexion_BBDD c = new Conexion_BBDD();
            c.delete("autor", " Nombre='" + nombre + "'");
        } catch (Exception ex) {
        }
        
    }

    @Test
    public void crear_nuevo_artista_existe() {
        try {
            String nombre = "Linkin Park";
            String fecha = "1988-08-09";
            Conexion_BBDD c = new Conexion_BBDD();
            String valores[]={"Nombre","Fecha_inicio"};
            String v_insertar[]={nombre,fecha};
            if((boolean)c.insertar("autor", valores, v_insertar)){
                assertTrue(false);
            }
        } catch (Exception ex) {
        }
    }
    
    @Test
    public void crear_nuevo_artista() {
        try {
            String nombre = "System of a down";
            String fecha = "1988-08-09";
            Conexion_BBDD c = new Conexion_BBDD();
            String valores[]={"Nombre","Fecha_inicio"};
            String v_insertar[]={nombre,fecha};
            if(!(boolean)c.insertar("autor", valores, v_insertar)){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);
        }
    }
    
    
}
