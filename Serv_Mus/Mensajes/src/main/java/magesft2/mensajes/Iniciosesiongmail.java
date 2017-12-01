/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.mensajes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import magesft.clases.Usuario;
import magesft.sockets.Sockets;
import magesft2.conectar.Conexion_BBDD;

/**
 *
 * @author ivan
 */
public class Iniciosesiongmail extends javax.swing.JFrame {

    DefaultListModel<Usuario> dfm;
    LinkedList<Usuario> l_user;
    JFrame jf;
    Usuario u;

    /**
     * Creates new form Iniciosesiongmail
     */
    public Iniciosesiongmail(JFrame jf) {
        try {
            this.jf = jf;
            initComponents();
            this.setLocationRelativeTo(null);
            dfm = new DefaultListModel<>();
            l_user = new LinkedList<>();

            String[] campos = {"Nombre_user", "Contrasenia", "Correo", "saldo", "rol"};
            Conexion_BBDD c = new Conexion_BBDD();
            ArrayList<String[]> arr = c.consulta("usuarios", campos, "");
            for (int i = 0; i < arr.size(); i++) {
                Usuario u = new Usuario(((String[]) arr.get(i))[0], ((String[]) arr.get(i))[1], ((String[]) arr.get(i))[2], Float.parseFloat(((String[]) arr.get(i))[3]), Integer.parseInt(((String[]) arr.get(i))[4]));
                l_user.add(u);
                dfm.add(i, u);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Iniciosesiongmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Iniciosesiongmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista_user.setModel(dfm);

    }

    public Iniciosesiongmail(JFrame jf, Usuario u) {
        initComponents();
        this.jf = jf;
        this.u = u;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        motivo = new javax.swing.JTextField();
        BtnEnviar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_user = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_mensaje = new javax.swing.JTextArea();
        t_contrasenia = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(580, 470));
        setMinimumSize(new java.awt.Dimension(580, 470));
        setPreferredSize(new java.awt.Dimension(580, 470));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(motivo);
        motivo.setBounds(315, 25, 265, 30);

        BtnEnviar.setText("Enviar");
        BtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEnviar);
        BtnEnviar.setBounds(389, 253, 80, 23);

        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(389, 310, 80, 23);

        jScrollPane1.setViewportView(lista_user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 11, 309, 322);

        t_mensaje.setColumns(20);
        t_mensaje.setRows(5);
        jScrollPane2.setViewportView(t_mensaje);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(310, 80, 265, 169);
        getContentPane().add(t_contrasenia);
        t_contrasenia.setBounds(123, 352, 144, 20);

        jLabel4.setText("Mensaje");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 60, 130, 14);

        jLabel3.setText("Asunto");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 10, 150, 14);

        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(25, 355, 80, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract-background-design.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, -10, 590, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnviarActionPerformed
        for (int i = 0; i < l_user.size(); i++) {
            try {
            
            String destinatario = l_user.get(i).getCorreo(); //A quien le quieres escribir.
            String asunto = motivo.getText();
            String cuerpo = t_mensaje.getText();

            enviarConGMail(destinatario, asunto, cuerpo);
        } catch (MessagingException ex) {
            Logger.getLogger(Iniciosesiongmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        

    }//GEN-LAST:event_BtnEnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void enviarConGMail(String destinatario, String asunto, String cuerpo) throws MessagingException {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "gonzalo.perez.fdz@gmail.com";  //Para la dirección nomcuenta@gmail.com

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", t_contrasenia.getText().trim());    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario, "Gonzalo"));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, t_contrasenia.getText().trim());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Iniciosesiongmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Usuario> lista_user;
    private javax.swing.JTextField motivo;
    private javax.swing.JPasswordField t_contrasenia;
    private javax.swing.JTextArea t_mensaje;
    // End of variables declaration//GEN-END:variables
}
