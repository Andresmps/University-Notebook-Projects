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
public class Pelicula extends Contenido {
    
    private String resumen;
    private int a�o;

    public Pelicula(String titulo, String resumen, int a�o) {
        super(titulo);
        this.resumen = resumen;
        this.a�o = a�o;
    }
    
    @Override
    public String toString() {
        return super.toString()+", Resumen: "+resumen+", A�o: "+a�o+" }";
    }
    
}
