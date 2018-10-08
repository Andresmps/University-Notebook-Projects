package catalogo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CISCO
 */
public class Catalogo {

    private ArrayList<Contenido> contenido = new ArrayList();
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Catalogo menu = new Catalogo();

        menu.desplegarMenu();

    }

    public void desplegarMenu() {

        String mensaje = "";

        mensaje += "     Menu: ";
        mensaje += "\n\t1. Agregar contenido";
        mensaje += "\n\t2. Eliminar contenido";
        mensaje += "\n\t3. Visualizar los contenidos";
        mensaje += "\n\t0. Salir";

        System.out.println(mensaje);
        int opcion = Integer.parseInt(scan.nextLine());
        opcion(opcion);
    }

    public void opcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarContenido();
                break;
            case 2:
                eliminarContenido();
                break;
            case 3:
                visualizarContenido();
                break;
            case 0:
                System.exit(0);
                break;

        }

        desplegarMenu();

    }

    private void agregarContenido() {

        System.out.println("<Pelicula> = <titulo> & <resumen> & <año>");
        System.out.println("<Serie> = <titulo> & <temporada> & <capitulo1> -"
                + " <capitulo2> - ... - <capituloN>");
        System.out.println("<nombreCapitulo> $ <resumenCapitulo>");

        String entrada = scan.nextLine();
        String detalles[] = entrada.split("&");

        if (entrada.contains("-")) {
            agregarSerie(detalles);
        } else {
            agregarPelicula(detalles);
        }

        System.out.println("Salida: ");
        System.out.println("");
        System.out.println("El contenido ha sido agredado.");
    }

    public void agregarSerie(String[] entrada) {

        String titulo = entrada[0];
        int temporada = Integer.parseInt(entrada[1]);
        ArrayList capitulo = convertirLista(entrada[2]);

        Contenido serieDis = new Serie(titulo, temporada, capitulo);

        contenido.add(serieDis);
    }

    public void agregarPelicula(String[] entrada) {

        String titulo = entrada[0];
        String resumen = entrada[1];
        int año = Integer.parseInt(entrada[2]);

        Contenido peliculaDis = new Pelicula(titulo, resumen, año);
        contenido.add(peliculaDis);
    }

    public ArrayList convertirLista(String capitulos) {

        ArrayList<Capitulo> capitulosTemp = new ArrayList();
        String lista[] = capitulos.split("-");
        
        for (int i = 0; i < lista.length; i++) {
            
            String listaTemp[] = lista[i].split("#");
            String nombre = listaTemp[0];
            String resumen = listaTemp[1];

            Capitulo capitulo = new Capitulo(nombre, resumen);
            capitulosTemp.add(capitulo);
        }

        return capitulosTemp;
    }

    private void eliminarContenido() {

        System.out.println("Digite el titulo del contenido que desea eliminar");

        String titulo = scan.nextLine();

        for (int i = contenido.size() - 1; i >= 0; i--) {
            if (titulo.equals(contenido.get(i).getTitulo())) {
                contenido.remove(i);
            }
        }
    }

    private void visualizarContenido() {

        for (int i = 0; i < contenido.size(); i++) {

            if (contenido.get(i) instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) contenido.get(i);
                System.out.println(pelicula);
            } else if (contenido.get(i) instanceof Serie) {
                Serie serie = (Serie) contenido.get(i);
                System.out.println(serie);;
            }

        }
    }

}
//chao&676&holauno#bgibgui-holados#buiiu
//hola&23&67576
