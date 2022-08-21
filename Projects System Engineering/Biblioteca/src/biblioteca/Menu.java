package biblioteca;

import java.util.Scanner;

/**
 *
 * @author camilo
 */
public class Menu {

    private Biblioteca biblioteca = new Biblioteca();
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.desplegarMenuBiblioteca();
    }

    public void desplegarMenuBiblioteca() {

        String mensaje = "Menú biblioteca, digite alguna de las siguientes opciones:";
        mensaje += "\n\t1. Ingresar autor.";
        mensaje += "\n\t2. Ingresar Libro.";
        mensaje += "\n\t3. Buscar libro por título.";
        mensaje += "\n\t4. Buscar libro por autor.";
        mensaje += "\n\t5. Mostrar todos los autores.";
        mensaje += "\n\t6. Mostrar todos los libros.";
        mensaje += "\n\t7. Salir.";

        System.out.println(mensaje);

        int opcion = Integer.parseInt(scan.nextLine());

        switch (opcion) {
            case 1:
                manejarOpcionIngresarAutor();
                break;
            case 2:
                manejarOpcionIngresarLibro();
                break;
            case 3:
                manejarOpcionBuscarLibrosPorTitulo();
                break;
            case 4:
                manejarOpcionBuscarLibrosPorAutor();
                break;
            case 5:
                manejarOpcionMostrarAutores();
                break;
            case 6:
                manejarOpcionMostrarLibros();
                break;
            case 7:
                System.exit(0);
                break;
            case 8:
                biblioteca.eliminarLibro(scan.nextLine()); 
                break;
        }
        desplegarMenuBiblioteca();
    }

    private void manejarOpcionIngresarAutor() {

        System.out.println("Uste ha seleccionado la opción 1, agregar autor.");
        System.out.println("Ingrese la información del autor.");

        String autor = scan.nextLine();

        if (!autor.isEmpty()) {

            String atributos[] = autor.split("&");
            biblioteca.agregarAutor(atributos[0], atributos[1], atributos[2]);

            System.out.println("");
            System.out.println("Salida:");
            System.out.println("El autor ha sido agregado");
        }

    }

    private void manejarOpcionIngresarLibro() {

        System.out.println("Usted ha seleccionado la opción 2, agregar libro.");
        System.out.println("Ingrese los datos de nuevo libro:");

        String libro = scan.nextLine();
        if (!libro.isEmpty()) {
            String[] atributos = libro.split("&");
            biblioteca.agregarLibro(atributos[0], atributos[1], Integer.parseInt(atributos[2]), Integer.parseInt(atributos[3]));

            System.out.println("");
            System.out.println("Salida:");
            System.out.println("El libro ha sido agregado.");
        }

    }

    private void manejarOpcionBuscarLibrosPorTitulo() {
        System.out.println("Usted ha seleccionado la opción 2, buscar libro por título.");
        System.out.println("Ingrese las palabras clave:");

        String palabrasClave = scan.nextLine();

        System.out.println("");
        System.out.println("Salida:");

        for (int i = 0; i < biblioteca.buscarLibrosPorTitulo(palabrasClave).size(); i++) {
            System.out.println(biblioteca.buscarLibrosPorTitulo(palabrasClave).get(i));
        }
    }

    private void manejarOpcionBuscarLibrosPorAutor() {
        System.out.println("Usted ha seleccionado la opción 4, buscar libros por autor. ");
        System.out.println("Ingrese el nombre del autor:");

        String autor = scan.nextLine();

        System.out.println("");
        System.out.println("Salida:");

        for (int i = 0; i < biblioteca.buscarLibrosPorAutor(autor).size(); i++) {
            System.out.println(biblioteca.buscarLibrosPorAutor(autor).get(i));
        }

    }

    private void manejarOpcionMostrarAutores() {
        System.out.println("Usted ha seleccionado la opción 5, mostrar autores.");

        System.out.println("");
        System.out.println("Salida:");

        for (int i = 0; i < biblioteca.darAutores().size(); i++) {
            System.out.println(biblioteca.darAutores().get(i));
        }

    }

    private void manejarOpcionMostrarLibros() {
        System.out.println("Usted ha seleccionado la opción 6, mostrar libros.");

        System.out.println("");
        System.out.println("Salida:");

        for (int i = 0; i < biblioteca.darLibros().size(); i++) {
            System.out.println(biblioteca.darLibros().get(i));
        }
    }
}
//Hello World :v :V
//Fix it :)
//full