/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import magesft.clases.Musica;
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
public class TestBuscarCanciones {
    
    public TestBuscarCanciones() {
    }
    
    
    
    
    @Test
    public void BuscarCancion_existe() {
        try {
            Musica c=new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", "4");
            
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String condicion = " where Nombre_cancion='" + c.getNombre() + "'";
            
            Conexion_BBDD con=new Conexion_BBDD();
            
            ArrayList<String[]> arr=(ArrayList<String[]>) con.consulta("musica", campos, condicion);
            if(arr.size()!=1){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);
        } 
    }
    @Test
    public void BuscarCancion_noexiste() {
        try {
            Musica c=new Musica("Despacito", "Fonsi", "6", "4", "../../../../Musica/despacito.mp3", "4");
            
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String condicion = " where Nombre_cancion='" + c.getNombre() + "'";
            Conexion_BBDD con=new Conexion_BBDD();
            ArrayList<String[]> arr=(ArrayList<String[]>)con.consulta("musica", campos, condicion);
            if(arr.size()!=1){
                assertTrue(true);
            }
        } catch (Exception ex) {
            assertTrue(false);
        } 
    }
}
