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
public class Serie extends Contenido{
    
    private int temporada;
    private ArrayList <Capitulo> capitulos;

    public Serie(String titulo, int temporada, ArrayList capitulos) {
        super(titulo);
        this.temporada = temporada;
        this.capitulos = capitulos;
    }
    
    @Override
    public String toString(){
        return super.toString()+", Temporada: "+temporada+", Capitulos: "+capitulos.toString()+" }";
    }
    
}
