/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.reproductor;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;
import java.util.Map;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import static sun.audio.AudioPlayer.player;


import javazoom.jlgui.basicplayer.BasicController; 
import javazoom.jlgui.basicplayer.BasicPlayer; 
import javazoom.jlgui.basicplayer.BasicPlayerEvent; 
import javazoom.jlgui.basicplayer.BasicPlayerException; 
import javazoom.jlgui.basicplayer.BasicPlayerListener; 

/**
 *
 * @author greg
 */
public class Reproductor {

    private BasicPlayer player = new BasicPlayer();

    public void Play() throws Exception {
        player.play();
    }   
    
    public long getSleepTime(){
        return player.getSleepTime();
    }
    
    public void prueba(){
        System.out.println(player.getLineBufferSize());
        System.out.println(player.getLineCurrentBufferSize());
        System.out.println("\n\n");
    }

    /*
    
    Estados :
        0 -> Reproduciendo
        1 -> Pausado (Supongo hay que probarlo)
        2 -> Terminado
        3 -> Sin cancion
    
    */

    public int getStatus() {
        return player.getStatus();
    }
    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void Pausa() throws Exception {
        player.pause();
    }

    public void Continuar() throws Exception {
        player.resume();
    }

    public void Stop() throws Exception {
        player.stop();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
