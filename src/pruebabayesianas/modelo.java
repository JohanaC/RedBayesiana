/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabayesianas;

import org.openmarkov.core.model.network.ProbNet;

/**
 *
 * @author Edgar
 */
public class modelo {
    public String nombre;
    public ProbNet resul;

    public modelo(String nombre, ProbNet resul) {
        this.nombre = nombre;
        this.resul = resul;
    }

    public modelo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProbNet getResul() {
        return resul;
    }

    public void setResul(ProbNet resul) {
        this.resul = resul;
    }
    
    
    
}
