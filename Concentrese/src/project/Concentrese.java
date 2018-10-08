package project;

/**
 *
 * @author Camilo Martínez
 * Hola Mundo :V
 */

import java.util.Scanner;

public class Concentrese {

    private Scanner scan = new Scanner(System.in);
    private Tablero tablero = new Tablero();
    private boolean condicion;

    public static void main(String[] args) {

        Concentrese menu = new Concentrese();
        menu.desplegarMenu();
    }

    public void desplegarMenu() {

        String mensaje = "";
        if (!condicion) {
            tablero.generarTablero();
            condicion = true;
        }

        System.out.println("Tablero: ");
        System.out.println("");
        tablero.mostrarTableroXX();
        System.out.println("");
        
        System.out.println("Aciertos: " + tablero.getAciertos());
        System.out.println("Vidas Restantes: " + tablero.getVidasRestantes());
        System.out.println("");

        mensaje += "Digite alguna de las siguientes opciones.";
        mensaje += "\n  1. Hacer jugada.";
        mensaje += "\n  2. Reiniciar partida.";
        mensaje += "\n  3. Reiniciar vidas.";
        mensaje += "\n  4. Salir.";
        mensaje += "\n  11. Mostrar todas las cartas.";
        mensaje += "\n  12. Dar palo más Repetido.";
        mensaje += "\n  13. Regalar pareja.";

        System.out.println(mensaje);

        String opcion = scan.nextLine();

        switch (Integer.parseInt(opcion)) {
            case 1:
                hacerJugada();
                break;
            case 2:
                tablero.generarTablero();
                break;
            case 3:
                reiniciarVidas();
                break;
            case 4:
                System.exit(0);
                break;
            case 11:
                mostrarTablero();
                
                break;
            case 12:
                paloRepetido();
                break;
            case 13:
                regalarPareja();

        }
        derrota(tablero.getVidasRestantes());
        victoria(tablero.getAciertos());
        desplegarMenu();
    }

    public void hacerJugada() {

        String carta1;
        String carta2;

        System.out.println("Usted ha seleccionado la opción 1, hacer jugada:");
        System.out.println("Ingrese las coordenadas de la carta que desea descubrir:");

        String str = scan.nextLine();
        String[] splito = str.split("&");

        int fila1 = Integer.parseInt(splito[0]);
        int columna1 = Integer.parseInt(splito[1]);

        carta1 = tablero.jugada1(fila1, columna1);

        if (carta1.equals("-1")) {
            System.out.println("***Esta Carta Ya Ha Sido Adivinada***");
        } else {
            System.out.println("");
            tablero.mostrarTableroXX();
            System.out.println("");
            System.out.println("Ha descubierto " + mostrarCarta(carta1));
            System.out.println("");
            System.out.println("Ingrese las coordenadas de la segunda carta:");

            String str1 = scan.nextLine();
            String[] splito1 = str1.split("&");

            int fila2 = Integer.parseInt(splito1[0]);
            int columna2 = Integer.parseInt(splito1[1]);

            carta2 = tablero.jugada2(fila2, columna2, fila1, columna1);
            if (tablero.mismaPosicion(fila2, columna2, fila1, columna1)) {
                System.out.println("*** Esta Posición Es La Misma Genio :V ***");
                desplegarMenu();
            } else {

                if (carta2.equals("-1")) {
                    System.out.println("***Esta Carta Ya Ha Sido Adivinada***");
                } else {
                    System.out.println("");
                    tablero.mostrarTableroXX();
                    System.out.println("");
                    if (tablero.validarJugada(fila1, columna1, fila2, columna2)) {
                        System.out.println("Ha descubierto " + mostrarCarta(carta2) +". Felicidades Ha Acertado :)");
                        System.out.println("");
                        victoria(tablero.getAciertos());
                    } else {
                        System.out.println("Ha descubierto " + mostrarCarta(carta2)+". Lo Siento Ha Fallado :(");
                        System.out.println("");
                        derrota(tablero.getVidasRestantes());
                    }
                }
            }
        }
    }

    public String mostrarCarta(String carta) {

        String carta1 = "";
        String palo = "";
        String subCarta = "" + carta.charAt(0) + carta.charAt(1);

        if (subCarta.equals("10")) {

            if (carta.charAt(2) == 'S') {
                palo = "Picas";
            } else if (carta.charAt(2) == 'H') {
                palo = "Corazones";
            } else if (carta.charAt(2) == 'D') {
                palo = "Diamantes";
            } else if (carta.charAt(2) == 'C') {
                palo = "Tréboles";
            }

            carta1 = "10 de " + palo;
        } else {

            if (carta.charAt(1) == 'S') {
                palo = "picas";
            } else if (carta.charAt(1) == 'H') {
                palo = "corazones";
            } else if (carta.charAt(1) == 'D') {
                palo = "diamantes";
            } else if (carta.charAt(1) == 'C') {
                palo = "tréboles";
            }

            carta1 = "" + carta.charAt(0) + " de " + palo;
        }

        return carta1;
    }

    public void victoria(int aciertos) {

        if (aciertos == 12) {
            System.out.println("***Felicidades Ha Ganado :)***");
            tablero.generarTablero();

        }

    }

    public void derrota(int vidas) {

        if (vidas == -1) {
            System.out.println("***Lo Sentimos Pero Ha Perdido :(***");
            tablero.generarTablero();
        }

    }

    public void reiniciarVidas() {

        tablero.setVidasRestantes(6);

    }

    public void mostrarTablero(){
        
        System.out.println("Usted ha seleccionado la opcion 11, trampa:");
        System.out.println("Salida:");
        System.out.println("Las cartas son:");
        tablero.mostrarTablero();
        System.out.println("");
        
    }
    
    public void paloRepetido(){
        
        System.out.println("Usted ha seleccionado la opción 12, dar palo más repetido.");
        System.out.println("Salida:");
        
        String str = tablero.darPaloMasRepetido();
        String []splito = str.split("&");
        
        System.out.println("");
        System.out.println("El palo más repetido es "+splito[0]+" con "+splito[1]+" cartas.");
        
    }
    
    public void regalarPareja(){
        
        System.out.println("Usted ha seleccionado la opción 13, ayuda:");
        System.out.println("Salida:");
        
        String str = tablero.regalo();
        String []splito = str.split("&");
        
        String carta = mostrarCarta(splito[0]);
        
        System.out.println("La carta descubierta es "+carta+" en ("+splito[1]+", "+splito[2]+") y ("+splito[3]+", "+splito[4]+"):");
        System.out.println("");
        
    }
   
    
    
}
