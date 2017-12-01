/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.reproductor;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import magesft.clases.Musica;
import org.tritonus.share.sampled.file.TAudioFileFormat;

/**
 *
 * @author greg
 */
public class Panel extends javax.swing.JFrame {

    static Reproductor rp = new Reproductor();
    static LinkedList<Musica> lista = new LinkedList();
    static int indice = 0;
    boolean pausado = false;
    boolean continuar = false;
    long tInicio = 0;
    long tPausa = 0;
    long restante = 0;
    Calendar cal = Calendar.getInstance();
    JFrame jf;

    Thread t = new Thread() {
        public void run() {
            System.out.println("Entro en hilo");
            System.out.println(t.getState());

            while (indice < lista.size()) {
                try {
                    File f = new File(lista.get(indice).getEnlace());
                    int m = getDurationWithMp3Spi(f);
                    if (continuar) {
                        rp.Continuar();
                        Thread.sleep(m-(tInicio-tPausa));
                        System.out.println("Reproduciendo: " + indice);
                        System.out.println("tiempo espera: " + m);
                        continuar=false;
                        siguienteCancion();

                    } else if (pausado){
                        
                    }else {
                        tInicio = cal.getTimeInMillis();
                        rp.AbrirFichero(lista.get(indice).getEnlace());
                        labelCancion.setText(lista.get(indice).getNombre());
                        rp.Play();
                        System.out.println("Reproduciendo: " + indice);
                        System.out.println("tiempo espera: " + m);
                        Thread.sleep(m);
                        siguienteCancion();
                    }

                    
                } catch (Exception ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            try {
                System.out.println("Entro al try");
                siguienteCancion();
            } catch (Exception ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private static int getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {

        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
            String key = "duration";
            Long microseconds = (Long) properties.get(key);
            int mili = (int) (microseconds / 1000);
            int sec = (mili / 1000) % 60;
            int min = (mili / 1000) / 60;
            return mili;
            //System.out.println("time = " + min + ":" + sec);
        } else {
            throw new UnsupportedAudioFileException();
        }

    }

    /**
     * Creates new form Prueba
     */

 
    

    public Panel(LinkedList l_musica,JFrame jf) {
        initComponents();
        this.jf=jf;
        lista=(LinkedList<Musica>)l_musica;
        labelCancion.setText(lista.getFirst().getNombre());
        File f = new File(lista.getFirst().getEnlace());
                int m=0;
                try {
                    m = getDurationWithMp3Spi(f);
                    System.out.println(m);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                System.out.println(lista.size());
                try {
                    rp.AbrirFichero(lista.get(indice).getEnlace());
                } catch (Exception ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }

    private void siguienteCancion() throws Exception {
        indice++;
        if (indice == lista.size()) {
            indice = 0;
        }
        System.out.println("Indice: " + indice);
        pausado = false;
        continuar = false;

    }

    private void anteriorCancion() throws Exception {
        indice--;
        if (indice < 0) {
            indice = lista.size() - 1;
        }
        System.out.println("Indice: " + indice);
        pausado = false;
            continuar = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonReproducir = new javax.swing.JButton();
        buttonPausa = new javax.swing.JButton();
        buttonContinuar = new javax.swing.JButton();
        buttonParar = new javax.swing.JButton();
        buttonSiguiente = new javax.swing.JButton();
        buttonAnterior = new javax.swing.JButton();
        labelCancion = new javax.swing.JLabel();
        Btnatras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(390, 315));
        setMinimumSize(new java.awt.Dimension(390, 315));
        setPreferredSize(new java.awt.Dimension(390, 315));
        getContentPane().setLayout(null);

        buttonReproducir.setText("|>");
        buttonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReproducirActionPerformed(evt);
            }
        });
        getContentPane().add(buttonReproducir);
        buttonReproducir.setBounds(148, 50, 71, 46);

        buttonPausa.setText("| |");
        buttonPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPausaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPausa);
        buttonPausa.setBounds(155, 126, 43, 23);

        buttonContinuar.setText("||>");
        buttonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonContinuar);
        buttonContinuar.setBounds(249, 126, 49, 23);

        buttonParar.setText("|_|");
        buttonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararActionPerformed(evt);
            }
        });
        getContentPane().add(buttonParar);
        buttonParar.setBounds(57, 126, 47, 23);

        buttonSiguiente.setText(">");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSiguiente);
        buttonSiguiente.setBounds(225, 179, 41, 23);

        buttonAnterior.setText("<");
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAnterior);
        buttonAnterior.setBounds(104, 179, 41, 23);

        labelCancion.setText("Cancion");
        getContentPane().add(labelCancion);
        labelCancion.setBounds(155, 254, 160, 14);
        labelCancion.getAccessibleContext().setAccessibleName("labelCancion");
        labelCancion.getAccessibleContext().setAccessibleDescription("labelCancion");

        Btnatras.setText("Atrás");
        Btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnatrasActionPerformed(evt);
            }
        });
        getContentPane().add(Btnatras);
        Btnatras.setBounds(10, 250, 80, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract-background-design.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(4, 0, 390, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReproducirActionPerformed
        try {
            // TODO add your handling code here:
            pausado = false;
            continuar = false;
            if (t.getState() == Thread.State.RUNNABLE) t.resume();
            else t.start();
            /*System.out.println(t.getState());
            t.start();*/
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonReproducirActionPerformed

    private void buttonPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPausaActionPerformed
        try {
            // TODO add your handling code here:
            pausado = true;
            continuar = false;
            tPausa = cal.getTimeInMillis();
            
            rp.Pausa();
            t.interrupt();
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPausaActionPerformed

    private void buttonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonContinuarActionPerformed
        if(rp.getStatus()==2){}
        else {
        try {
            // TODO add your handling code here:
            //rp.Continuar();
            pausado = false;
            continuar = true;
            t.resume();
            rp.Continuar();
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }//GEN-LAST:event_buttonContinuarActionPerformed

    private void buttonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPararActionPerformed
        try {
            // TODO add your handling code here:
            pausado = true;
            continuar = false;
            t.interrupt();
            rp.Stop();
            System.out.println(t.getState());
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPararActionPerformed

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed
        // TODO add your handling code here:
        try {
            siguienteCancion();
            System.out.println(t.getState());
            t.interrupt();
            t.resume();
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSiguienteActionPerformed

    private void buttonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnteriorActionPerformed
        try {
            anteriorCancion();
            t.interrupt();
            t.resume();
        } catch (Exception ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAnteriorActionPerformed

    private void BtnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnatrasActionPerformed
        jf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BtnatrasActionPerformed

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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnatras;
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonContinuar;
    private javax.swing.JButton buttonParar;
    private javax.swing.JButton buttonPausa;
    private javax.swing.JButton buttonReproducir;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelCancion;
    // End of variables declaration//GEN-END:variables

}
