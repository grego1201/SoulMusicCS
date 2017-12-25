/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.crearusuario;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import magesft.clases.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import magesft.crearusuario.CrearUsuario;
import magesft.sockets.Sockets;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author ivan
 */
public class TestCreacion {
    static CrearUsuario c;
    public TestCreacion() {
        
    }
    @Test
    public void testcrearautomatico(){
        assertTrue(c.metodocrearautomatico());
    }
    @Test
    public void test1() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
   
    @Test
    public void test2(){
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
    @Test
    public void test3() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(c.metodocrearusuarionormal());
    }
    @Test
    public void test4() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(c.metodocrearusuarionormal());
    }
    @Test
    public void test5() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("Correo");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
    @Test
     public void test6() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("Correo");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
     @Test
      public void test7() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(c.metodocrearusuarionormal());
    }
      @Test
      public void test8() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("Usuario");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(c.metodocrearusuarionormal());
    }
       @Test
      public void test9() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
      @Test
      public void test10() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
      @Test
      public void test11() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
      @Test
      public void test12() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("Contrasenia");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
      
      @Test
      public void test13() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
       @Test
      public void test14() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("correo");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
      @Test
      public void test15() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(0);
        assertTrue(!c.metodocrearusuarionormal());
    }
      @Test
      public void test16() throws IOException, ClassNotFoundException{
        
        c.txtUsuario.setText("");
        c.txtContrasenia.setText("");
        c.txtCorreo.setText("");
        c.cmbRol.setSelectedIndex(1);
        assertTrue(!c.metodocrearusuarionormal());
    }
    @BeforeClass
    public static void setUpClass() {
        c=new CrearUsuario();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }

    @After
    public void EliminarUsuario() {
        Usuario u = new Usuario("usuario", "Gonzalo", "Gonzalo@gmail.com", 0, 1);
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

 
        } catch (ClassNotFoundException ex) {
            
        } finally {
            try {
                out.flush();
                out.close();
                in.close();
                s.close();
            } catch (IOException ex) {            }
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
