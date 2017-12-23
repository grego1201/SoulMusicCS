/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
                if ((boolean) in.readObject()) {
                    System.out.println("todo bien");
                }
            } catch (Exception ex1) {

            }

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


    /*@Test
    public void Comprar_bien() {
        for(int i=0;i<artista.length;i++){
            for(int j=0;i<nombre.length;j++){
                
                Sockets so = new Sockets();
                ObjectInputStream in = so.getIn();
                ObjectOutputStream out = so.getOut();

                Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", 0, 0);
                Musica c=new Musica(nombre[i], artista[i], "6", "4", "../../../../Musica/in_the_end.mp3", "4");
                    try {
                        String[] campos = {"Cancion", "Usuario"};
                        String [] insertar = {c.getIden(),u.getUsuario()};
                        System.out.println(in.readObject());
                        out.writeObject(0);
                        out.writeObject("usuariocancion");
                        out.writeObject(campos);
                        out.writeObject(insertar);
                        assertTrue((boolean)in.readObject());

                    } catch (Exception ex) {
                     fail("UnexpectedException" + ex);
                    }
                
            }
        }
    }*/
    int[] saldo = {-5, 0, 3, 5, 7};
    String[] total = {"-5", "0", "3", "5", "7"};

    @Test
    public void ComprarSaldo() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[0], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[0]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                System.out.println("Estoy aqui");
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            System.out.println("Entro en el catch");
            assertTrue(false);
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
    public void ComprarSaldo2() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[0], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[1]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo3() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[0], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[2]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo4() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[0], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[3]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo5() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[0], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[4]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo6() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[1], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[0]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo7() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[1], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[1]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo8() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[1], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[2]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
           // }
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo9() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[1], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[3]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo10() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[1], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[4]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo11() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[2], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[0]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo12() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[2], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[1]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo13() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[2], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[2]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo14() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[2], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[3]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo15() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[2], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[4]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo16() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[3], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[0]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo17() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[3], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[1]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo18() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[3], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[2]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo19() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[3], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[3]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo20() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[3], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[4]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo21() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[4], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[0]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo22() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[4], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[1]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo23() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[4], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[2]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo24() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[4], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[3]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
    public void ComprarSaldo25() {
        Sockets so = new Sockets();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();
        Socket s = so.getS();
        //for (int i = 0; i < saldo.length; i++) {
        // for (int j = 0; j < total.length; j++) {
        try {
            Usuario u = new Usuario("Comprador", "Comprador", "Comprador@gmail.com", saldo[4], 0);
            float saldo = u.getSaldo();
            Musica c = new Musica("in the end", "Linkin Park", "6", "4", "../../../../Musica/in_the_end.mp3", total[4]);
            float total = Float.parseFloat(c.getPrecio());
            //if (saldo >= total && saldo > 0 && total > 0) {
                String[] campos = {"Cancion", "Usuario"};
                String[] insertar = {c.getIden(), u.getUsuario()};
                System.out.println(in.readObject());
                out.writeObject(0);
                out.writeObject("usuariocancion");
                out.writeObject(campos);
                out.writeObject(insertar);
                if ((boolean) in.readObject()) {
                    assertTrue(saldo >= total);
                }
            //}
        } catch (Exception ex) {
            assertTrue(false);
        } finally {
            //}
            //}
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
}
