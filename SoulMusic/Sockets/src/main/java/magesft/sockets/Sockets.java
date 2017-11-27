/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Gonzalo
 */
public class Sockets {

    ObjectInputStream in;
    ObjectOutputStream out;
    Socket s;

    public Sockets() {
        ObjectInputStream in;
        ObjectOutputStream out;
        Socket s=null;
        String[] campos = {};
        boolean no_preparado = false;
        try {
            String serverAddress = "192.168.0.31";
            do {
                try {
                    s = new Socket(serverAddress, 4445);
                    no_preparado = false;
                } catch (Exception ex) {
                    no_preparado = true;
                }
            } while (no_preparado);
            in = new ObjectInputStream(s.getInputStream());
            out = new ObjectOutputStream(s.getOutputStream());
            this.in=in;
            this.out=out;
            this.s=s;
        } catch (Exception ex) {

        }
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
    
    
    

}
