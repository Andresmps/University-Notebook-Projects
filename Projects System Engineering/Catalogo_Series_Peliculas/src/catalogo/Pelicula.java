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
    private int año;

    public Pelicula(String titulo, String resumen, int año) {
        super(titulo);
        this.resumen = resumen;
        this.año = año;
    }
    
    @Override
    public String toString() {
        return super.toString()+", Resumen: "+resumen+", Año: "+año+" }";
    }
    
}
