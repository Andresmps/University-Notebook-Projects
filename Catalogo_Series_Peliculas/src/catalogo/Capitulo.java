/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogo;

/**
 *
 * @author CISCO
 */
public class Capitulo {
    
    private String nombre;
    private String resumen;

    public Capitulo(String nombre, String resumen){
        
        this.nombre = nombre;
        this.resumen = resumen;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public String getResumen() {
        return resumen;
    }
    
    @Override
    public String toString(){
        
        return "{ Nombre:"+nombre+", resumen: "+resumen+" }";
    }
}
