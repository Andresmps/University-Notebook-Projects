package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class Libro {
    
    private ArrayList <Autor> autores = new ArrayList();
    private String titulo;
    private int cantidad;
    private int paginas;
    
    public Libro(String titulo, ArrayList autores, int cantidad, int paginas) {
        
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.paginas = paginas;
        this.autores = autores;
        
    }
    
    public int getCantidad(){
        
        return cantidad;
    }
    public int getPaginas(){
        
        return paginas;
    }
    
    public String darTitulo(){
     
        return titulo;
    }
    
    public ArrayList darAutores(){
        
        return autores;
    }
    
    public ArrayList darNombresAutores(){
        
        ArrayList <String> autoresNombres = new ArrayList();
        
        for (int i = 0; i < autores.size(); i++) {
            Autor autorTemp = autores.get(i);
            autoresNombres.add(autorTemp.darNombre());
        }
        
        return autoresNombres;
    }
    
    @Override
    public String toString(){
        
        String mensaje = "{titulo: "+titulo+", autores: "+darNombresAutores().toString()+", cantidad: "+cantidad+", paginas: "+paginas+"}";
        
        return mensaje;
    }
}
