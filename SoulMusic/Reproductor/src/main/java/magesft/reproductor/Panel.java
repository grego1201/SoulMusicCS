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
                        labelCancion.setText(lista.get(indice).getEnlace());
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
    public Panel() {
        initComponents();
    }

    

    public Panel(LinkedList l_musica) {
        initComponents();
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

    }

    private void anteriorCancion() throws Exception {
        indice--;
        if (indice < 0) {
            indice = lista.size() - 1;
        }
        System.out.println("Indice: " + indice);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonReproducir.setText("|>");
        buttonReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReproducirActionPerformed(evt);
            }
        });

        buttonPausa.setText("| |");
        buttonPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPausaActionPerformed(evt);
            }
        });

        buttonContinuar.setText("||>");
        buttonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonContinuarActionPerformed(evt);
            }
        });

        buttonParar.setText("|_|");
        buttonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararActionPerformed(evt);
            }
        });

        buttonSiguiente.setText(">");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });

        buttonAnterior.setText("<");
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });

        labelCancion.setText("Cancion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(buttonReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(buttonAnterior)
                        .addGap(80, 80, 80)
                        .addComponent(buttonSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(buttonParar)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCancion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonPausa)
                                .addGap(51, 51, 51)
                                .addComponent(buttonContinuar)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(buttonReproducir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPausa)
                    .addComponent(buttonParar)
                    .addComponent(buttonContinuar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAnterior)
                    .addComponent(buttonSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(labelCancion)
                .addGap(30, 30, 30))
        );

        labelCancion.getAccessibleContext().setAccessibleName("labelCancion");
        labelCancion.getAccessibleContext().setAccessibleDescription("labelCancion");

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

                /*lista.add("1.mp3");
                lista.add("2.mp3");
                lista.add("3.mp3");
                lista.add("4.mp3");*/
                
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonContinuar;
    private javax.swing.JButton buttonParar;
    private javax.swing.JButton buttonPausa;
    private javax.swing.JButton buttonReproducir;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JLabel labelCancion;
    // End of variables declaration//GEN-END:variables
}
