/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.buscarcanciones.BuscarCanciones;
import magesft.clases.Musica;
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
public class TestBuscarCanciones {
    
    public TestBuscarCanciones() {
    }
    
    
    
    @Test
    public void BuscarCancion_existe() {
        try {
            Musica c=new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", "4");
            Sockets so=new Sockets();
            ObjectInputStream in=so.getIn();
            ObjectOutputStream out=so.getOut();
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String condicion = " where Nombre_cancion='" + c.getNombre() + "'";
            System.out.println(in.readObject());
            out.writeObject(1);
            out.writeObject("musica");
            out.writeObject(campos);
            out.writeObject(condicion);
            ArrayList<String[]> arr=(ArrayList<String[]>) in.readObject();
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
            Sockets so=new Sockets();
            ObjectInputStream in=so.getIn();
            ObjectOutputStream out=so.getOut();
            String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace","Precio"};
            String condicion = " where Nombre_cancion='" + c.getNombre() + "'";
            System.out.println(in.readObject());
            out.writeObject(1);
            out.writeObject("musica");
            out.writeObject(campos);
            out.writeObject(condicion);
            ArrayList<String[]> arr=(ArrayList<String[]>) in.readObject();
            if(arr.size()!=1){
                assertTrue(true);
            }
        } catch (Exception ex) {
            assertTrue(false);
        } 
    }
}