/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.eliminarcanciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import magesft.clases.Musica;
import magesft.sockets.Sockets;

/**
 *
 * @author Gonzalo
 */
public class EliminarCanciones extends javax.swing.JFrame {

    DefaultListModel<Musica> dfm;
    LinkedList<Musica> l_musica;
    int album_borrar;

    /**
     * Creates new form EliminarCanciones
     */
    public EliminarCanciones() {
        initComponents();
        try {
            album_borrar = -1;
            dfm = new DefaultListModel<>();
            l_musica = new LinkedList<>();
            Sockets so = new Sockets();

            Socket s = so.getS();
            ObjectInputStream in = so.getIn();
            ObjectOutputStream out = so.getOut();

            System.out.println(in.readObject());
            String[] campos = {"Nombre"};
            String condicion = "";
            out.writeObject(1);
            out.writeObject("autor");
            out.writeObject(campos);
            out.writeObject(condicion);
            ArrayList<String[]> arr = (ArrayList<String[]>) in.readObject();

            for (int i = 0; i < arr.size(); i++) {
                c_artistas.addItem(((String[]) arr.get(i))[0]);
            }

            so = new Sockets();
            s = so.getS();
            in = so.getIn();
            out = so.getOut();

            System.out.println(in.readObject());
            String[] campos2 = {"ID", "Nombre_album"};
            out.writeObject(1);
            out.writeObject("album");
            out.writeObject(campos2);
            out.writeObject(condicion);
            arr = (ArrayList<String[]>) in.readObject();

            for (int i = 0; i < arr.size(); i++) {
                c_album.addItem(((String[]) arr.get(i))[0] + "-" + ((String[]) arr.get(i))[1]);
            }

        } catch (IOException ex) {
            Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        c_artistas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        c_album = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        l_titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_musica = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar canciones:");

        c_artistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel2.setText("Artista:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Album:");

        c_album.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel4.setText("Titulo: ");

        jScrollPane1.setViewportView(list_musica);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_artistas, 0, 119, Short.MAX_VALUE)
                            .addComponent(c_album, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(l_titulo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(jButton2)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(c_artistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(c_album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        l_musica = new LinkedList<>();
        dfm = new DefaultListModel<>();
        Sockets so = new Sockets();
        ArrayList<String[]> musica = new ArrayList<>();
        Socket s = so.getS();
        ObjectInputStream in = so.getIn();
        ObjectOutputStream out = so.getOut();

        String artistas = (String) c_artistas.getSelectedItem();
        String album = (String) c_album.getSelectedItem();
        String nombre = l_titulo.getText();

        if (nombre.compareToIgnoreCase("") != 0) {
            try {
                String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                String condicion = " where Nombre_cancion='" + nombre + "'";
                System.out.println(in.readObject());
                out.writeObject(1);
                out.writeObject("musica");
                out.writeObject(campos);
                out.writeObject(condicion);
                ArrayList<String[]> arr = (ArrayList<String[]>) in.readObject();
                for (int i = 0; i < arr.size(); i++) {
                    musica.add(arr.get(i));
                }

            } catch (IOException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (artistas.compareToIgnoreCase("") != 0) {

                try {
                    String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                    String condicion = " where Autor='" + artistas + "'";
                    System.out.println(in.readObject());
                    out.writeObject(1);
                    out.writeObject("musica");
                    out.writeObject(campos);
                    out.writeObject(condicion);
                    ArrayList<String[]> arr = (ArrayList<String[]>) in.readObject();
                    for (int i = 0; i < arr.size(); i++) {
                        musica.add(arr.get(i));
                    }

                } catch (IOException ex) {
                    Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (album.compareToIgnoreCase("") != 0) {
                    try {
                        String[] campos = {"ID_Musica"};
                        album_borrar=Integer.parseInt(album.substring(0, album.indexOf("-")));
                        String condicion = " where ID_Album='" + String.valueOf(album_borrar) + "'";
                        System.out.println(in.readObject());
                        out.writeObject(1);
                        out.writeObject("linea_album");
                        out.writeObject(campos);
                        out.writeObject(condicion);
                        ArrayList<String[]> arr = (ArrayList<String[]>) in.readObject();

                        String[] campos2 = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                        for (int i = 0; i < arr.size(); i++) {
                            so = new Sockets();

                            s = so.getS();
                            in = so.getIn();
                            out = so.getOut();
                            condicion = " where ID='" + ((String[]) arr.get(i))[0] + "'";
                            System.out.println(in.readObject());
                            out.writeObject(1);
                            out.writeObject("musica");
                            out.writeObject(campos2);
                            out.writeObject(condicion);
                            arr = (ArrayList<String[]>) in.readObject();
                            musica.add(arr.get(0));
                        }
                        for (int i = 0; i < musica.size(); i++) {
                            System.out.println(((String[]) musica.get(i))[0]);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Rellena alguno de los campos");
                }

            }
        }
        for (int i = 0; i < musica.size(); i++) {
            String cancion = "";
            Musica m = new Musica(((String[]) musica.get(i))[0], ((String[]) musica.get(i))[1], ((String[]) musica.get(i))[2], ((String[]) musica.get(i))[3], ((String[]) musica.get(i))[4], ((String[]) musica.get(i))[5]);
            l_musica.add(m);
            dfm.add(i, m);
        }
        list_musica.setModel(dfm);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (album_borrar != -1) {
            try {
                Sockets so = new Sockets();

                Socket s = so.getS();
                ObjectInputStream in = so.getIn();
                ObjectOutputStream out = so.getOut();
                String condicion = " ID_Album='" + String.valueOf(album_borrar) + "'";

                System.out.println(in.readObject());
                out.writeObject(3);
                out.writeObject("linea_album");
                out.writeObject(condicion);

                so = new Sockets();

                s = so.getS();
                in = so.getIn();
                out = so.getOut();
                condicion = " ID='" + album_borrar + "'";

                System.out.println(in.readObject());
                out.writeObject(3);
                out.writeObject("album");
                out.writeObject(condicion);

                

            } catch (IOException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int i = 0; i < l_musica.size(); i++) {
            try {
                Sockets so = new Sockets();
                
                Socket s = so.getS();
                ObjectInputStream in = so.getIn();
                ObjectOutputStream out = so.getOut();
                String condicion = " ID='" + l_musica.get(i).getIden() + "'";
                
                System.out.println(in.readObject());
                out.writeObject(3);
                out.writeObject("musica");
                out.writeObject(condicion);
            } catch (IOException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EliminarCanciones.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
        EliminarCanciones el=new EliminarCanciones();
        el.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EliminarCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCanciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> c_album;
    private javax.swing.JComboBox<String> c_artistas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField l_titulo;
    private javax.swing.JList<Musica> list_musica;
    // End of variables declaration//GEN-END:variables
}
