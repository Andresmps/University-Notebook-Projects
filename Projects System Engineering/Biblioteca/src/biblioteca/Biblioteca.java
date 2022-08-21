package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public class Biblioteca {

    private ArrayList<Autor> autores = new ArrayList();
    private ArrayList<Libro> libros = new ArrayList();

    public Biblioteca() {

    }

    public void agregarAutor(String nombre, String mail, String genero) {

        Autor autor = new Autor(nombre, mail, genero);
        autores.add(autor);
    }

    public void agregarLibro(String titulo, String autores, int cantidad, int paginas) {

        String[] vectorAutores = autores.split("_");
        ArrayList autoresEnc = buscarAutores(vectorAutores);
        
        if (!autoresEnc.isEmpty()) {
            Libro libro = new Libro(titulo, autoresEnc, cantidad, paginas);
            libros.add(libro);
        }else 
            System.out.println("\n***El autor para este libro aún no ha sido agregado***");

    }

    public ArrayList buscarAutores(String[] vectorAutores) {

        ArrayList<Autor> autoresEnc = new ArrayList();

        for (int i = 0; i < vectorAutores.length; i++) {
            String nombreAutor = vectorAutores[i];
            Autor autorEnc = buscarAutor(nombreAutor);
            if (autorEnc != null) {
                autoresEnc.add(autorEnc);
            }
        }

        return autoresEnc;
    }

    public Autor buscarAutor(String nombreAutor) {

        for (int i = 0; i < autores.size(); i++) {
            Autor autorTemp = autores.get(i);
            if (nombreAutor.equals(autorTemp.darNombre())) {
                return autorTemp;
            }
        }
        return null;
    }

    public ArrayList buscarLibrosPorTitulo(String titulo) {

        ArrayList<Libro> librosEnc = new ArrayList();

        for (int i = 0; i < libros.size(); i++) {
            Libro libroTemp = libros.get(i);
            if(buscarLibros(titulo, librosEnc,libroTemp) != null)
                librosEnc.add(buscarLibros(titulo, librosEnc,libroTemp));
        }

        if (titulo.equals("")) {
            librosEnc.clear();
        }

        return librosEnc;
    }

    public Libro buscarLibros(String titulo, ArrayList librosEnc, Libro libro) {

        String palabrasClaves[] = titulo.split("&");
        
        for (int i = 0; i < palabrasClaves.length; i++) {
            String clave = palabrasClaves[i];
            if (buscarLibro(libro.darTitulo(), clave)) {
                return libro;
            }
        }
        return null;
    }

    public boolean buscarLibro(String titulo, String clave) {

        String palabraTitulo[] = titulo.split(" ");

        for (int i = 0; i < palabraTitulo.length; i++) {
            String palabraTemp = palabraTitulo[i];
            if (palabraTemp.equals(clave)) {
                return true;
            }

        }
        return false;
    }

    public ArrayList buscarLibrosPorAutor(String nombreAutor) {

        ArrayList<Libro> librosEnc = new ArrayList();

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if (buscarAutores(nombreAutor, libro) != null) {
                librosEnc.add(buscarAutores(nombreAutor, libro));
            }
        }

        if (nombreAutor.equals("")) {
            librosEnc.clear();
        }

        return librosEnc;
    }

    public Libro buscarAutores(String nombreAutor, Libro libro) {

        for (int i = 0; i < libro.darNombresAutores().size(); i++) {
            String autorTemp = "" + libro.darNombresAutores().get(i);
            if (autorTemp.equals(nombreAutor)) {
                return libro;
            }
        }

        return null;
    }

    public ArrayList darAutores() {

        return autores;
    }

    public ArrayList darLibros() {

        return libros;
    }
    
    public void eliminarLibro(String nombreAutor){
        
        for (int i = libros.size()-1; i > -1; i--) {
            Libro libroTemp = libros.get(i);
            if(compararAutores(libroTemp, nombreAutor))
                libros.remove(i);
        }
        
    }
    
    public boolean compararAutores(Libro libro, String nombreAutor){
        
        for (int i = 0; i < libro.darNombresAutores().size(); i++) {
            String autor = ""+libro.darNombresAutores().get(i);
            if(compararAutor(autor, nombreAutor))
                return true;
        }
        
        return false;
    }
    
    public boolean compararAutor(String autor, String nombreAutor){
        
        return autor.equals(nombreAutor);
    }
    
}
