package proyectnumber3;

/**
 *
 * @author Camilo Martínez
 */
import static java.lang.System.exit;

import java.util.Scanner;

public class Menu {

    private CompiladorNotas compiladorNotas;
    private Scanner scan;
    String nombreMateria = "No definida.";

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.desplegarOpciones();
    }

    public Menu() {
        compiladorNotas = null;
        scan = new Scanner(System.in);
    }

    public void desplegarOpciones() {

        int opcion;

        String mensaje = "--- Compilador de notas ---";
        mensaje += "\n--- Materia: " + nombreMateria;
        mensaje += "\nMenú, digite alguna de las siguiente opciones:";
        mensaje += "\n   1. Inicializar/Reiniciar materia.";
        mensaje += "\n   2. Agregar calificable.";
        mensaje += "\n   3. Mostrar información calificables.";
        mensaje += "\n   4. Cambiar porcentaje de calificable.";
        mensaje += "\n   5. Asignar nota a calificable.";
        mensaje += "\n   6. Eliminar calificable por índice.";
        mensaje += "\n   7. Eliminar calificable por nombre.";
        mensaje += "\n   8. Salir.";
        mensaje += "\n   9. Dar nota de la materia.";
        System.out.println(mensaje);

        opcion = Integer.parseInt(scan.nextLine());

        if (compiladorNotas == null) {
            if (opcion == 1) {
                manejarOpcionInicializarMateria();
            } else {
                desplegarOpciones();
            }

        } else {

            switch (opcion) {
                case 1:
                    manejarOpcionInicializarMateria();
                    break;
                case 2:
                    manejarOpcionAgregarCalificable();
                    break;
                case 3:
                    mostrarCalificable();
                    break;
                case 4:
                    manejarOpcionCambiarPorcentajeNota();
                    break;
                case 5:
                    manejarOpcionAsignarNota();
                    break;
                case 6:
                    manejarOpcionEliminarCalificable();
                    break;
                case 7:
                    manejarOpcionEliminarCalificabl();
                    break;
                case 9:
                    manejarOpcionDarNotaDefinitiva();
                    break;
                case 8:
                    System.exit(0);
                    break;
                
            }

        }
        desplegarOpciones();
    }

    private void manejarOpcionInicializarMateria() {
        System.out.println("Usted ha seleccionado la opción 1, inicializar materia.");
        System.out.print("Ingrese los datos de la materia: ");
        nombreMateria = scan.nextLine();
        compiladorNotas = new CompiladorNotas(nombreMateria);
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("La materia ha sido inicializada.");
        System.out.println("");
    }

    private void manejarOpcionAgregarCalificable() {

        System.out.println("Usted ha seleccionado la opción 2, agregar calificable.");
        System.out.print("ingrese los datos del calificable: ");

        String CRUD = scan.nextLine();
        String[] splito = CRUD.split("&");

        String nombre = splito[0];
        Double porcentaje = Double.parseDouble(splito[1]);
        String descripcion = splito[2];

        compiladorNotas.agregarNota(nombre, porcentaje, descripcion);

        System.out.println("");
        System.out.println("Salida:");
        System.out.println("El calificable ha sido registrado.");
        System.out.println("");
    }

    private void mostrarCalificable() {

        System.out.println("Usted ha seleccionado la opción 3, mostrar calificables.");
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("Materia: " + nombreMateria);
        System.out.println(compiladorNotas);
        System.out.println("");
    }

    private void manejarOpcionCambiarPorcentajeNota() {
        System.out.println("Usted ha seleccionado la opción 4, cambiar porcentaje de calificable.");
        System.out.print("Ingrese los datos: ");
        String str = scan.nextLine();
        String[] splito = str.split("&");
        String nombre = splito[0];
        double porcentaje = Double.parseDouble(splito[1]);

        compiladorNotas.cambiarPorcentajeNota(nombre, porcentaje);
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("El porcentaje del " + nombre + " ha sido modificado.");
        System.out.println("");

    }

    private void manejarOpcionAsignarNota() {
        System.out.println("Usted ha seleccionado la opción 5, actualizar nota de calificable.");
        System.out.print("Ingrese los datos: ");

        String str = scan.nextLine();
        String[] splito = str.split("&");

        String nombre = splito[0];
        Double nota = Double.parseDouble(splito[1]);

        compiladorNotas.asignarNota(nombre, nota);
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("La nota del" + nombre + " ha sido actualizada.");
        System.out.println("");

    }

    private void manejarOpcionEliminarCalificable() {
        System.out.println("Usted ha seleccionado la opción 6, eliminar calificable por índice.");
        System.out.print("Ingrese el índice del calificable: ");
        String indice = scan.nextLine();
        compiladorNotas.eliminarNota(indice);
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("El calificable ha sido eliminado correctamente.");

    }

    private void manejarOpcionEliminarCalificabl() {
        System.out.println("Usted ha seleccionado la opción 7, eliminar calificable por nombre.");
        System.out.print("Ingrese el nombre del calificable: ");
        String nombre = scan.nextLine();
        compiladorNotas.eliminarNot(nombre);
        System.out.println("");
        System.out.println("Salida:");
        System.out.println("El calificable ha sido eliminado correctamente.");

    }

    private void manejarOpcionDarNotaDefinitiva() {
        System.out.println("Usted ha seleccionado la opción 9, dar nota definitva.");
        System.out.println("");
        System.out.println("Salida:");

        if (compiladorNotas.darNotaOptenida() != -1) {
            System.out.println("Su nota de la materia " + nombreMateria + " es de " + (float) compiladorNotas.darNotaOptenida());
        } else {
            System.out.println("El porcentaje " + compiladorNotas.darPorcentaje() + "% es incorrecto.");
        }

    }

}
//7
//hola
