/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogo;

import java.util.ArrayList;

/**
 *
 * @author CISCO
 */
public class Contenido {

    private String titulo;
    
    public Contenido(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString(){
     
        return ("{ Titulo: "+titulo);
    }
    
}
