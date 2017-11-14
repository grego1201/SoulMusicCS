/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.crearusuario;

/**
 *
 * @author 9alej
 */
public class Usuario {
    
    private String usuario, contrasenia, correo;
    private float saldo;
    
    public Usuario(String usuario, String contrasenia, String correo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.saldo = 0;
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
}
