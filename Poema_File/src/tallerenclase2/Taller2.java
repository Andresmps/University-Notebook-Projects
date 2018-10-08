/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerenclase2;

import com.sun.istack.internal.logging.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * @author CISCO
 */
public class Taller2 {

    private PoemAnalysisLinearListExtension instaciaPoema = new PoemAnalysisLinearListExtension();
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Taller2 main = new Taller2();
        main.menu();
    }

    private void menu() {

        BufferedReader bf = null;
        String line;

        try {

            bf = new BufferedReader(new FileReader("Text.txt"));
            File file = new File("Text_Modificado.txt");
            PrintWriter escribir = new PrintWriter(file);

            while ((line = bf.readLine()) != null) {
                
                instaciaPoema.crearListaLineal(line);
            }

            System.out.println("*** Menu ***");
            System.out.println("1) Precargar los datos del taller.");
            System.out.println("2) Digitar los datos usted mismo.");

            int opcion = Integer.parseInt(scan.nextLine());
            switch (opcion) {
                case 1:
                    precargarDatos(escribir);
                    break;
                case 2:
                    ingresarDatos(escribir);
                    break;
                default:
                    menu();
            }

            escribir.close();
            bf.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Taller2.class).log(Level.SEVERE, null, ex);
        }

    }

    // Carga el formato del taller, y pide los datos para poder hacer lo que piden los puntos
    
    public void ingresarDatos(PrintWriter escribir) {

        String palabraTemp = "";
        String palabraTemp2 = "";
        System.out.println("\n\t***Taller en Clase Estructuras de Datos***\n");
        
        System.out.println("1. Lea el archivo de entrada Text.txt y añada cada palabra como un elemento de una "
                + "Lista Lineal.");
        System.out.println("");
        
        System.out.println("2. Muestre el contenido del poema como una Lista Lineal:");
        System.out.println(instaciaPoema);
        System.out.println("");
        
        System.out.println("3. Muestre la primera posición de una palabra dada en el poema siendo cero la primera "
                + "posición.");
        System.out.println("Ingrese la primera palabra");
        palabraTemp = scan.nextLine();
        System.out.println("Primera posición de la palabra "+palabraTemp+": "  
                +instaciaPoema.indexOf(palabraTemp));
        System.out.println("Ingrese la segunda palabra");
        palabraTemp = scan.nextLine();
        System.out.println("Primera posición de la palabra "+palabraTemp+": "
                + instaciaPoema.indexOf(palabraTemp));
        System.out.println("");
        
        System.out.println("4. Muestre el número de veces de una palabra dada en el poema.");
        palabraTemp = scan.nextLine();
        System.out.println("Número de veces de la palabra "+ palabraTemp+": " + instaciaPoema.palabrasRepetidas(palabraTemp));
        System.out.println("");
        
        System.out.println("5. Desarrolle un método que intercambie dos palabras en la Lista donde está almacenado "
                + "el poema");
        System.out.println("");
        
        System.out.println("6. Para los métodos de los pasos 2, 3, 4 y 5, cual es la complejidad en términos de Big "
                + "O?");
        notacionBigO();
        System.out.println("");
        
        
        System.out.println("7. Utilizando el método del paso 5, imprima en otro archivo el resultado de intercambiar "
                + "las palabras:");
        palabraTemp = scan.nextLine();
        palabraTemp2 = scan.nextLine();
        newFile(palabraTemp, palabraTemp2, escribir);

    }

    // Carga el formato del taller con los mismos datos del taller
    
    public void precargarDatos(PrintWriter escribir) {

        System.out.println("\n\t***Taller en Clase Estructuras de Datos***\n");
        System.out.println("1. Lea el archivo de entrada Text.txt y añada cada palabra como un elemento de una "
                + "Lista Lineal.");
        System.out.println("");
        System.out.println("2. Muestre el contenido del poema como una Lista Lineal:");
        System.out.println(instaciaPoema);
        System.out.println("");
        System.out.println("3. Muestre la primera posición de una palabra dada en el poema siendo cero la primera "
                + "posición.");
        System.out.println("Primera posición de la palabra tactica:" + instaciaPoema.indexOf("tactica"));
        System.out.println("Primera posición de la palabra estrategia:" + instaciaPoema.indexOf("estrategia"));
        System.out.println("");
        System.out.println("4. Muestre el número de veces de una palabra dada en el poema.");
        System.out.println("numero de veces de la palabra tactica:" + instaciaPoema.palabrasRepetidas("tactica"));
        System.out.println("");
        System.out.println("5. Desarrolle un método que intercambie dos palabras en la Lista donde está almacenado "
                + "el poema");
        System.out.println("");
        System.out.println("6. Para los métodos de los pasos 2, 3, 4 y 5, cual es la complejidad en términos de Big "
                + "O?");
        notacionBigO();
        System.out.println("");
        System.out.println("7. Utilizando el método del paso 5, imprima en otro archivo el resultado de intercambiar "
                + "las palabras “táctica” y “estrategia” quedando así:");
        newFile("tactica", "estrategia", escribir);

    }

    //Escribe en el nuevo texto creado
    public void newFile(String palabraUno, String palabraDos, PrintWriter escribir) {

        String file = instaciaPoema.newFile(palabraUno, palabraDos);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------\n");
        escribir.println(file); 
        System.out.println(file);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        
    }

    public void notacionBigO() {

        System.out.println("");
        System.out.println("     *** NOTACIÓN BIG O ***");
        System.out.println("");
        System.out.println("\t2) O(size)");
        System.out.println("\t3) O(size)");
        System.out.println("\t4) O(size)");
        System.out.println("\t5) O(size^2)");

    }

}
