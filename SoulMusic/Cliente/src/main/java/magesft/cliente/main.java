/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.cliente;

import javax.swing.UIManager;
import magesft.loginusuario.LoginUsuario;

/**
 *
 * @author ivan
 */
public class main {
 
    public static void main(String[]args){
       try{
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
           
       } catch (Exception e){
           e.printStackTrace();
       }
        Inicio n=new Inicio();
        n.setVisible(true);
        
    }
}
