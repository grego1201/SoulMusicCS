/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.servidor;

import java.util.ArrayList;
import magesft.clases.Musica;
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
public class TestCrearMusica {
    public TestCrearMusica() {
    }
    
    
    
    public int maximoID_test(ArrayList<String[]> arr){
         int maximo=0;
         for (int i = 0; i < arr.size(); i++) {
             if(maximo<Integer.parseInt(((String[])arr.get(i))[0])){
                 maximo=Integer.parseInt(((String[])arr.get(i))[0]);
             }
         }
         return maximo;
     }

    @Test
    public void crear_nueva_musica_existe() {
        try {
            
            Musica m=new Musica("MusicaPrueba", "Linkin Park",String.valueOf(1) , "4", "pruebaenlace", "4");
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String[] insertar = {m.getNombre(),m.getAutor(),m.getIden(),m.getDuracion(), m.getEnlace(), m.getPrecio()};
            Conexion_BBDD c = new Conexion_BBDD();
            if((boolean)c.insertar("musica", campos, insertar)){
                assertTrue(false);
            }
        } catch (Exception ex) {
        }
    }
    
    @Test
    public void crear_nueva_musica() {
        try {
            String camp[]={"ID"};
            Conexion_BBDD c = new Conexion_BBDD();
            ArrayList<String[]> arr=c.consulta("musica", camp, "");
            int id=maximoID_test(arr)+1;
            Musica m=new Musica("MusicaPrueba", "Linkin Park",String.valueOf(id) , "4", "pruebaenlace", "4");
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String[] insertar = {m.getNombre(),m.getAutor(),m.getIden(),m.getDuracion(), m.getEnlace(), m.getPrecio()};
            c = new Conexion_BBDD();
            if(!(boolean)c.insertar("musica", campos, insertar)){
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);
        }
    }
}
