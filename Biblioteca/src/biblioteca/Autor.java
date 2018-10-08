package biblioteca;

/**
 *
 * @author camilo
 */
public class Autor {
 
    private String nombre;
    private String mail;
    private String genero;
    
    public Autor(String nombre, String mail, String genero) {
        this.nombre = nombre;
        this.mail = mail;
        this.genero = genero;
    }
    
    public String darNombre(){
        
        return nombre;
    }
    
    @Override
    public String toString(){
        
        String mensaje = "{nombre: "+nombre+", mail: "+mail+", genero: "+genero+"}";
        
        return mensaje;
    }
}
