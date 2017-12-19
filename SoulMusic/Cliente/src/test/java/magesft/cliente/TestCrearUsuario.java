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
import java.util.logging.Level;
import java.util.logging.Logger;
import magesft.clases.Usuario;
import magesft.crearusuario.CrearUsuario;
import magesft.sockets.Sockets;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Gonzalo
 */
public class TestCrearUsuario {
    @BeforeClass
    public static void EliminarUsuario() {
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
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

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
    @Test
    public void CrearUser_bien2() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", -2, 0);
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
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

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
    @Test
    public void CrearUser_bien3() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", -2, 1);
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
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

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
    @Test
    public void CrearUser_bien4() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 2, 0);
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
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

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
    @Test
    public void CrearUser_bien5() {
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", 2, 1);
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
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(false);

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
  
    public void CrearUser() {
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
                
            }
        } catch (Exception ex) {
            assertTrue(false);

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
    @Test
    public void CrearUser_mal() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", "Gonzalo@gmail.com", -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal2() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", null, 0, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal3() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", null, -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal4() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", null, 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal5() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", "Gonzalo", null, 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal6() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,"Gonzalo@gmail.com", -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal7() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,"Gonzalo@gmail.com", -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal8() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,"Gonzalo@gmail.com", 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal9() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,"Gonzalo@gmail.com", 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal10() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,null, -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal11() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,null, -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal12() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,null, 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal13() {
        CrearUser();
        Usuario u = new Usuario("Gonzalo", null,null, 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal14() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", "Gonzalo@gmail.com", -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal15() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", "Gonzalo@gmail.com", -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal16() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", "Gonzalo@gmail.com", 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal17() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", "Gonzalo@gmail.com", 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal18() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", null, -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal19() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", null, -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal20() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", null, 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal21() {
        CrearUser();
        Usuario u = new Usuario(null, "Gonzalo", null, 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal22() {
        CrearUser();
        Usuario u = new Usuario(null, null, "Gonzalo@gmail.com", -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal23() {
        CrearUser();
        Usuario u = new Usuario(null, null, "Gonzalo@gmail.com", -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal24() {
        CrearUser();
        Usuario u = new Usuario(null, null, "Gonzalo@gmail.com", 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal25() {
        CrearUser();
        Usuario u = new Usuario(null, null, "Gonzalo@gmail.com", 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal26() {
        CrearUser();
        Usuario u = new Usuario(null, null, null, -2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal27() {
        CrearUser();
        Usuario u = new Usuario(null, null, null, -2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal28() {
        CrearUser();
        Usuario u = new Usuario(null, null, null, 2, 0);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
    public void CrearUser_mal29() {
        CrearUser();
        Usuario u = new Usuario(null, null, null, 2, 1);
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
            if ((boolean) in.readObject()) {
                assertTrue(false);
            }
        } catch (Exception ex) {
            assertTrue(true);

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
}
