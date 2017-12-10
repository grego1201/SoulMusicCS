/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.eliminarusuario;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import magesft.clases.Usuario;
import magesft.sockets.Sockets;
import magesft2.conectar.Conexion_BBDD;


/**
 *
 * @author Gonzalo
 */
public class EliminarUsuario extends javax.swing.JFrame {
DefaultListModel<Usuario> dfm;
LinkedList<Usuario> l_user;
JFrame jf;
    /**
     * Creates new form EliminarUsuario
     */
    public EliminarUsuario(JFrame jf) {
        this.jf=jf;
        initComponents();
        try {
            this.setLocationRelativeTo(null);
            Sockets so=new Sockets();
            dfm=new DefaultListModel<>();
            l_user=new LinkedList<>();
            Socket s=so.getS();
            ObjectInputStream in=so.getIn();
            ObjectOutputStream out=so.getOut();
            String[] campos = {"Nombre_user", "Contrasenia", "Correo", "saldo","rol"};
            
            System.out.println(in.readObject());
            out.writeObject(1);
            out.writeObject("usuarios");
            out.writeObject(campos);
            out.writeObject("");
            ArrayList<String[]> arr=(ArrayList<String[]>) in.readObject();
            for (int i = 0; i < arr.size(); i++) {
                
                Usuario u = new Usuario(((String[])arr.get(i))[0], ((String[])arr.get(i))[1], ((String[])arr.get(i))[2], Float.parseFloat(((String[])arr.get(i))[3]), Integer.parseInt(((String[])arr.get(i))[4]));
                l_user.add(u);
                dfm.add(i, u);
            }
        } catch (IOException ex) {
            Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista_user.setModel(dfm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista_user = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Btnatras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(455, 380));
        setMinimumSize(new java.awt.Dimension(455, 380));
        setPreferredSize(new java.awt.Dimension(455, 380));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(lista_user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 59, 427, 239);

        jLabel1.setText("Eliminar Usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(188, 27, 130, 17);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 310, 110, 29);

        Btnatras.setText("Atrás");
        Btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnatrasActionPerformed(evt);
            }
        });
        getContentPane().add(Btnatras);
        Btnatras.setBounds(10, 310, 110, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract-background-design.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-6, 0, 460, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // TODO add your handling code here:
        Usuario u=lista_user.getSelectedValue();
        
        Conexion_BBDD c=new Conexion_BBDD();
        if(!c.delete("usuarios", " Nombre_user='"+u.getUsuario()+"'")){
            JOptionPane.showMessageDialog(this, "No se ha podido eliminar el usuario");
        }
    }  catch (ClassNotFoundException ex) {
        Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    EliminarUsuario el=new EliminarUsuario(jf);
    this.setVisible(false);
    el.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnatrasActionPerformed
        jf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnatrasActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnatras;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Usuario> lista_user;
    // End of variables declaration//GEN-END:variables
}
