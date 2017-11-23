/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.clases;

/**
 *
 * @author 9alej
 */
public class Usuario {
    
    private String usuario, contrasenia, correo;
    private float saldo;
    private int rol;
    
    public Usuario(String usuario, String contrasenia, String correo,int rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = 0;
        this.rol=rol;
    }
    public Usuario(String usuario, String contrasenia, String correo,float saldo,int rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = saldo;
        this.rol=rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public float getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "usuario=" + usuario + ", contrasenia=" + contrasenia + ", correo=" + correo + ", saldo=" + saldo ;
    }
    
    
}
