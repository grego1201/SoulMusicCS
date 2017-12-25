/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.buscarcanciones;

import junit.framework.TestCase;
import magesft.clases.Usuario;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author gonzalo
 */
public class TestBuscarCanciones extends TestCase {
    @Test
    public void testbuscar_sin_nada() {
        BuscarCanciones c = new BuscarCanciones(null);
        //c.c_artistas.setSelectedIndex(1);
        //c.c_album.setToolTipText("1-");
        //c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    @Test
    public void testbuscar_artista() {
        BuscarCanciones c = new BuscarCanciones(null);
        c.c_artistas.setSelectedIndex(1);
        assertTrue(c.buscar());
    }
    @Test
    public void testbuscar_album() {
        BuscarCanciones c = new BuscarCanciones(null);
        c.c_album.setSelectedIndex(1);
        assertTrue(c.buscar());
    }
    @Test
    public void testbuscar_titulo() {
        BuscarCanciones c = new BuscarCanciones(null);
        c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    
    @Test
    public void testbuscar_sinuser() {
        BuscarCanciones c = new BuscarCanciones();
    }
}
