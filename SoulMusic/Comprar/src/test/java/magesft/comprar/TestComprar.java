/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.comprar;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.clases.Musica;
import magesft.clases.Usuario;
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
    @Test
    public void testbuscar_sin_nada() {
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 0));
        //c.c_artistas.setSelectedIndex(1);
        //c.c_album.setToolTipText("1-");
        //c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    
    @Test
    public void testbuscar_artista() {
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 0));
        c.c_artistas.setSelectedIndex(1);
        //c.c_album.setToolTipText("1-");
        //c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    @Test
    public void testbuscar_album() {
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 0));
        //c.c_artistas.setSelectedIndex(1);
        c.c_album.setSelectedIndex(1);
        //c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    @Test
    public void testbuscar_titulo() {
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 2000, 0));
        //c.c_artistas.setSelectedIndex(1);
        //c.c_album.setSelectedIndex(1);
        c.l_titulo.setText("numb");
        assertTrue(c.buscar());
    }
    
    @Test
    public void testbuscar_sinuser() {
        Comprar c = new Comprar();
    }
    public void borrar_compra(Musica m, Usuario u){
        try {
            Sockets s=new Sockets();
            ObjectInputStream in=s.getIn();
            ObjectOutputStream out=s.getOut();
            
            in.readObject();
            out.writeObject(3);
            out.writeObject("usuariocancion");
            out.writeObject(" Cancion='"+m.getIden()+"' AND Usuario='"+u.getUsuario()+"'");
            System.out.println(in.readObject());
        } catch (IOException ex) {
            Logger.getLogger(TestComprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestComprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void poner_saldo(Usuario u){
        try {
            Sockets s=new Sockets();
            ObjectInputStream in=s.getIn();
            ObjectOutputStream out=s.getOut();
            String [] valores={"saldo"};
            String[] v_insertar={String.valueOf(u.getSaldo())};
            in.readObject();
            out.writeObject(2);
            out.writeObject("usuarios");
            out.writeObject(valores);
            out.writeObject(v_insertar);
            out.writeObject(" Nombre_user='"+u.getUsuario()+"'");
            in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(TestComprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestComprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testcomprar_album(){
        Musica m=new Musica("numb", "Linkin Park", "1", "4:00", "../../../../Musica/numb.mp3", "1.5");
        borrar_compra(m,new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com",2000,0));
        poner_saldo(new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com",2000,0));
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 2000, 0));
        c.l_musica.add(m);
        assertTrue(c.comprar());
    }
    @Test
    public void testcomprar_album_sin_saldo(){
        Musica m=new Musica("numb", "Linkin Park", "1", "4:00", "../../../../Musica/numb.mp3", "1.5");
        borrar_compra(m,new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com",0,0));
        poner_saldo(new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com",0,0));
        Comprar c = new Comprar(null, new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 0, 0));
        c.l_musica.add(m);
        assertTrue(c.comprar());
    }
    

}
