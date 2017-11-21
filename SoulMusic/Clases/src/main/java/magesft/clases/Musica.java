/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.clases;

import java.io.Serializable;

/**
 *
 * @author Gonzalo
 */
public class Musica implements Serializable{
    String nombre,autor,iden,duracion,enlace,precio;

    public Musica(String nombre, String autor, String iden, String duracion, String enlace, String precio) {
        this.nombre = nombre;
        this.autor = autor;
        this.iden = iden;
        this.duracion = duracion;
        this.enlace = enlace;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", autor=" + autor + ", iden=" + iden + ", duracion=" + duracion + ", precio=" + precio;
    }
    
}
