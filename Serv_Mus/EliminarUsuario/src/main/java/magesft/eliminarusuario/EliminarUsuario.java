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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import magesft.clases.Usuario;
import magesft.sockets.Sockets;


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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lista_user);

        jLabel1.setText("Eliminar Usuario:");

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Btnatras.setText("Atrás");
        Btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnatrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 178, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Btnatras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Btnatras))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // TODO add your handling code here:
        Usuario u=lista_user.getSelectedValue();
        Sockets so=new Sockets();
        Socket s=so.getS();
        ObjectInputStream in=so.getIn();
        ObjectOutputStream out=so.getOut();
        
        System.out.println(in.readObject());
        out.writeObject(3);
        out.writeObject("usuarios");
        out.writeObject(" Nombre_user='"+u.getUsuario()+"'");
    } catch (IOException ex) {
        Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Usuario> lista_user;
    // End of variables declaration//GEN-END:variables
}
