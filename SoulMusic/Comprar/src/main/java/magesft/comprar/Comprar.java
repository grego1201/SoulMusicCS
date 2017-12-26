/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.comprar;

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
import javax.swing.JOptionPane;
import magesft.clases.Musica;
import magesft.clases.Usuario;
import magesft.sockets.Sockets;

/**
 *
 * @author Gonzalo
 */
public class Comprar extends javax.swing.JFrame {

    DefaultListModel<Musica> dfm;
    LinkedList<Musica> l_musica;
    JFrame jf;
    Usuario usuario;

    /**
     * Creates new form BuscarCanciones
     */
    public Comprar(){
        initComponents();
    }
    public Comprar(final JFrame jf, final Usuario usuario) {
        this.jf = jf;
        this.usuario = usuario;
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            dfm = new DefaultListModel<>();
            l_musica = new LinkedList<>();
            Sockets socket = new Sockets();
            ObjectInputStream inputStream = socket.getIn();
            ObjectOutputStream out = socket.getOut();

            System.out.println(inputStream.readObject());
            final String[] campos = {"Nombre"};
            final String condicion = "";
            out.writeObject(1);
            out.writeObject("autor");
            out.writeObject(campos);
            out.writeObject(condicion);
            ArrayList<String[]> arr = (ArrayList<String[]>) inputStream.readObject();

            for (int i = 0; i < arr.size(); i++) {
                c_artistas.addItem(((String[]) arr.get(i))[0]);
            }

            socket = new Sockets();
            inputStream = socket.getIn();
            out = socket.getOut();

            System.out.println(inputStream.readObject());
            final String[] campos2 = {"ID", "Nombre_album"};
            out.writeObject(1);
            out.writeObject("album");
            out.writeObject(campos2);
            out.writeObject(condicion);
            arr = (ArrayList<String[]>) inputStream.readObject();

            for (int i = 0; i < arr.size(); i++) {
                c_album.addItem(((String[]) arr.get(i))[0] + "-" + ((String[]) arr.get(i))[1]);
            }

        } catch (IOException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        c_album = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        l_titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_musica = new javax.swing.JList<>();
        boton_comprar = new javax.swing.JButton();
        Btnatras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(681, 415));
        getContentPane().setLayout(null);

        jLabel1.setText("Buscar canciones:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(432, 26, 190, 14);

        c_artistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getContentPane().add(c_artistas);
        c_artistas.setBounds(101, 64, 119, 20);

        jLabel2.setText("Artista:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(22, 67, 80, 14);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 360, 90, 23);

        jLabel3.setText("Album:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(22, 119, 80, 14);

        c_album.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        getContentPane().add(c_album);
        c_album.setBounds(101, 116, 119, 20);

        jLabel4.setText("Titulo: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(22, 175, 80, 14);
        getContentPane().add(l_titulo);
        l_titulo.setBounds(101, 172, 119, 20);

        jScrollPane1.setViewportView(list_musica);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(319, 64, 331, 307);

        boton_comprar.setText("Comprar");
        boton_comprar.setEnabled(false);
        boton_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_comprarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_comprar);
        boton_comprar.setBounds(200, 360, 90, 23);

        Btnatras.setText("Atrás");
        Btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnatrasActionPerformed(evt);
            }
        });
        getContentPane().add(Btnatras);
        Btnatras.setBounds(10, 360, 80, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract-background-design.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-6, 0, 690, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       buscar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_comprarActionPerformed
        comprar();
        jf.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_boton_comprarActionPerformed

    private void BtnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnatrasActionPerformed
        jf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnatrasActionPerformed
    public boolean comprar(){
        try {
            boolean error = false;
            Sockets socket = new Sockets();
            ObjectInputStream inputStream = socket.getIn();
            ObjectOutputStream outputStream = socket.getOut();

            final String[] campos1 = {"saldo"};
            System.out.println(inputStream.readObject());
            outputStream.writeObject(1);
            outputStream.writeObject("usuarios");
            outputStream.writeObject(campos1);
            outputStream.writeObject(" where Nombre_user='" + usuario.getUsuario() + "'");
            final ArrayList<String[]> arr_saldo = (ArrayList<String[]>) inputStream.readObject();
            final float saldo = Float.parseFloat(((String[]) arr_saldo.get(0))[0]);
            float total_precio = 0;
            for (int i = 0; i < l_musica.size(); i++) {
                total_precio += Float.parseFloat(l_musica.get(i).getPrecio());
            }
            if (saldo >= total_precio) {
                for (int i = 0; i < l_musica.size(); i++) {
                    try {
                        // TODO add your handling code here:
                        socket = new Sockets();
                        inputStream = socket.getIn();
                        outputStream = socket.getOut();

                        final String[] campos2 = {"Usuario", "Cancion"};
                        final String[] insertar = {usuario.getUsuario(), l_musica.get(i).getIden()};
                        final String tabla = "usuariocancion";
                        System.out.println(inputStream.readObject());
                        outputStream.writeObject(0);
                        outputStream.writeObject(tabla);
                        outputStream.writeObject(campos2);
                        outputStream.writeObject(insertar);
                        if (!(boolean) inputStream.readObject()) {
                            error = true;
                        }
                    } catch (IOException ex) {
                        return false;
                    } catch (ClassNotFoundException ex) {
                        return false;
                    }
                }
                if (error == true) {
                    JOptionPane.showMessageDialog(this, "Eror al comprobar precio");
                    return false;
                } else {
                    socket = new Sockets();
                    inputStream = socket.getIn();
                    outputStream = socket.getOut();

                   final String[] campos3 = {"saldo"};
                   final float s_ins = saldo - total_precio;
                   final String[] insertar_sal = {String.valueOf(s_ins)};

                    System.out.println(inputStream.readObject());
                    outputStream.writeObject(2);
                    outputStream.writeObject("usuarios");
                    outputStream.writeObject(campos3);
                    outputStream.writeObject(insertar_sal);
                    outputStream.writeObject(" Nombre_user='" + usuario.getUsuario() + "'");
                    if(!(boolean)inputStream.readObject()){
                        JOptionPane.showMessageDialog(this, "Error al comprobar saldo");
                        return false;
                    }
                    JOptionPane.showMessageDialog(this, "Compra realizada");
                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "No tienes saldo suficiente");
                return true;
            }
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
        return true;
    }
    
    
    public boolean buscar(){
         final String artistas = (String) c_artistas.getSelectedItem();
           final String album = (String) c_album.getSelectedItem();
            final String nombre = l_titulo.getText();
        if(artistas.compareToIgnoreCase("")==0 && album.compareToIgnoreCase("")==0 && nombre.compareToIgnoreCase("")==0){
            JOptionPane.showMessageDialog(null, "rellena alguno de los campos");
            return true;
        }
         try {
            // TODO add your handling code here:
            l_musica = new LinkedList<>();
            dfm = new DefaultListModel<>();

            Sockets socket = new Sockets();
            final ArrayList<String[]> musica = new ArrayList<>();
            ObjectInputStream inputStream = socket.getIn();
            ObjectOutputStream outputStream = socket.getOut();

            final String[] camp = {"Cancion"};

            System.out.println(inputStream.readObject());
            outputStream.writeObject(1);
            outputStream.writeObject("usuariocancion");
            outputStream.writeObject(camp);
            outputStream.writeObject(" where Usuario='" + usuario.getUsuario() + "'");
            final ArrayList<String[]> compradas = (ArrayList<String[]>) inputStream.readObject();

            socket = new Sockets();
            inputStream = socket.getIn();
            outputStream = socket.getOut();

            
            String cond_id = " ";
            for (int i = 0; i < compradas.size(); i++) {
                cond_id = cond_id.concat(" and ID <>'" + ((String[]) compradas.get(i))[0] + "'") ;

            }
            if (nombre.compareToIgnoreCase("") != 0) {
                try {
                    final String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                    final String condicion = " where Nombre_cancion='" + nombre + "'" + cond_id;
                    System.out.println(inputStream.readObject());
                    outputStream.writeObject(1);
                    outputStream.writeObject("musica");
                    outputStream.writeObject(campos);
                    outputStream.writeObject(condicion);
                    final ArrayList<String[]> arr = (ArrayList<String[]>) inputStream.readObject();
                    for (int i = 0; i < arr.size(); i++) {
                        musica.add(arr.get(i));
                    }

                } catch (IOException ex) {
                    return false;
                } catch (ClassNotFoundException ex) {
                    return false;
                }
            } else {
                if (artistas.compareToIgnoreCase("") != 0) {

                    try {
                       final String[] campos = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                       final String condicion = " where Autor='" + artistas + "'" + cond_id;
                        System.out.println(inputStream.readObject());
                        outputStream.writeObject(1);
                        outputStream.writeObject("musica");
                        outputStream.writeObject(campos);
                        outputStream.writeObject(condicion);
                        final ArrayList<String[]> arr = (ArrayList<String[]>) inputStream.readObject();
                        for (int i = 0; i < arr.size(); i++) {
                            musica.add(arr.get(i));
                        }

                    } catch (IOException ex) {
                        return false;
                    } catch (ClassNotFoundException ex) {
                        return false;
                    }
                } else {
                    if (album.compareToIgnoreCase("") != 0) {
                        try {
                            final String[] campos = {"ID_Musica"};
                            String condicion = " where ID_Album='" + album.substring(0, album.indexOf("-")) + "'";
                            System.out.println(inputStream.readObject());
                            outputStream.writeObject(1);
                            outputStream.writeObject("linea_album");
                            outputStream.writeObject(campos);
                            outputStream.writeObject(condicion);
                            ArrayList<String[]> arr = (ArrayList<String[]>) inputStream.readObject();

                            final String[] campos2 = {"Nombre_cancion", "Autor", "ID", "Duracion", "enlace", "Precio"};
                            for (int i = 0; i < arr.size(); i++) {
                                socket = new Sockets();

                                inputStream = socket.getIn();
                                outputStream = socket.getOut();
                                condicion = " where ID='" + ((String[]) arr.get(i))[0] + "'" + cond_id;
                                System.out.println(inputStream.readObject());
                                outputStream.writeObject(1);
                                outputStream.writeObject("musica");
                                outputStream.writeObject(campos2);
                                outputStream.writeObject(condicion);
                                arr = (ArrayList<String[]>) inputStream.readObject();
                                musica.add(arr.get(0));
                            }
                            for (int i = 0; i < musica.size(); i++) {
                                System.out.println(((String[]) musica.get(i))[0]);
                            }

                        } catch (IOException ex) {
                            return false;
                        } catch (ClassNotFoundException ex) {
                            return false;
                        }
                    } 

                }
            }
            for (int i = 0; i < musica.size(); i++) {
               final String cancion = "";
               final Musica cancion_musica = new Musica(((String[]) musica.get(i))[0], ((String[]) musica.get(i))[1], ((String[]) musica.get(i))[2], ((String[]) musica.get(i))[3], ((String[]) musica.get(i))[4], ((String[]) musica.get(i))[5]);
                l_musica.add(cancion_musica);
                dfm.add(i, cancion_musica);
            }
            list_musica.setModel(dfm);
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }finally{
             
         }
        if (!l_musica.isEmpty()) {
            boton_comprar.setEnabled(true);
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnatras;
    private javax.swing.JButton boton_comprar;
    public javax.swing.JComboBox<String> c_album;
    public javax.swing.JComboBox<String> c_artistas;
    public final javax.swing.JButton jButton1 = new javax.swing.JButton();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField l_titulo;
    private javax.swing.JList<Musica> list_musica;
    // End of variables declaration//GEN-END:variables
}
