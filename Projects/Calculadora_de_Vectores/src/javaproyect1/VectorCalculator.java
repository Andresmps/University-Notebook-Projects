package javaproyect1;

import java.util.Scanner;

//       Camilo Andrés                     Martínez Vargas
//       614172005                         
//       Matemáticas                       Segundo semestre
//       17/02/2018
public class VectorCalculator {

    private static final Scanner scan = new Scanner(System.in);
    private static double x, x1, y, y1, z, z1;
    private static double[] v1 = new double[3];
    private static double[] v2 = new double[3];

    public static void main(String[] args) {
        mostrarMenu();

    }

    private static void mostrarMenu() {
        opciones();
        mostrarMenu();

    }

    private static void menu() {

        String menu = "\tCalculadora 3D";
        menu += "\nMen�, digite alguna de las siguiente opciones:";
        menu += "\n1. Ingresar vector 1.";
        menu += "\n2. Ingresar vector 2.";
        menu += "\n3. Sumar vectores.";
        menu += "\n4. Restar vectores.";
        menu += "\n5. Verificar cectores paralelos.";
        menu += "\n6. Verificar vectores perpendiculares.";
        menu += "\n7. Mostrar vectores.";
        menu += "\n8. Salir.";
        menu += "\n11. Escalar vectores. ";
        menu += "\n12. Invertir vectores.";
        menu += "\n13. Normaliar vectores.";
        menu += "\n14. Bono opción.";

        System.out.println(menu);

    }

    private static void opciones() {
        menu();
        int option = Integer.parseInt(scan.next());

        switch (option) {
            case 1:
                vector1();
                break;
            case 2:
                vector2();
                break;
            case 3:
                sumaVectores();
                break;
            case 4:
                restaVectores();
                break;
            case 5:
                vectoresParalelos();
                break;
            case 6:
                vectoresPerpendiculares();
                break;
            case 7:
                mostrarVectores();
                break;
            case 8:
                System.exit(0);
                break;
            case 11:
                escalarVectores();
                break;
            case 12:
                invertirVectores();
                break;
            case 13:
                normalizarVectores();
                break;
            case 14:
                bonoOpcion();
                break;
            default:
                mostrarMenu();
                break;
        }
    }

    private static void vector1() {

        System.out.println("Usted ha seleccionado la opción 1, ingresar vector 1.");
        System.out.print("Ingrese los componentes del vector: ");

        String valores = scan.next();
        String[] splito = valores.split("&");

        x = Double.parseDouble(splito[0]);
        y = Double.parseDouble(splito[1]);
        z = Double.parseDouble(splito[2]);

        System.out.println("\nSalida:\n");
        System.out.println("El vector {" + x + ", " + y + ", " + z + "} ha sido guardado en el espacio 1.");

    }

    private static void vector2() {

        System.out.println("Usted ha seleccionado la opción 2, ingresar vector 2.");
        System.out.print("Ingrese los componentes del vector: ");

        String valores = scan.next();
        String[] splito = valores.split("&");

        x1 = Double.parseDouble(splito[0]);
        y1 = Double.parseDouble(splito[1]);
        z1 = Double.parseDouble(splito[2]);

        System.out.println("\nSalida:\n");
        System.out.println("El vector {" + x1 + ", " + y1 + ", " + z1 + "} ha sido guardado en el espacio 2.");

    }

    private static void sumaVectores() {

        System.out.println("Usted ha seleccionado la opción 3, sumar vectores.");
        System.out.println("Salida:");
        System.out.println("\n\t   " + x + " " + y + " " + z);
        System.out.println("\t+  " + x1 + " " + y1 + " " + z1);
        System.out.println("\t----------------");
        System.out.println("\t   " + (x + x1) + " " + (y + y1) + " " + (z + z1));

    }

    private static void restaVectores() {

        System.out.println("Usted ha seleccionado la opción 3, restar vectores.");
        System.out.println("Salida:");
        System.out.println("\n\t   " + x + " " + y + " " + z);
        System.out.println("\t-  " + x1 + " " + y1 + " " + z1);
        System.out.println("\t----------------");
        System.out.println("\t   " + (x - x1) + " " + (y - y1) + " " + (z - z1));

    }

    private static void vectoresParalelos() {

        System.out.println("Usted ha seleccionado la opción 5, verificar vectores paralelos.");
        System.out.println("Salida:\n");
        double a = (x / x1);
        double b = (y / y1);
        double c = (z / z1);

        if (a == 0 || x1 == 0) {
            if (b == c) {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} si son paralelos.");
            } else {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} no son paralelos.");
            }

        } else if (b == 0 || y1 == 0) {
            if (a == c) {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} si son paralelos.");
            } else {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} no son paralelos.");
            }

        } else if (c == 0 || z1 == 0) {
            if (a == b) {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} si son paralelos.");
            } else {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} no son paralelos.");
            }
        } else {
            if (a == b && b == c) {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} si son paralelos.");
            } else {
                System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} no son paralelos.");
            }
        }
    }

    private static void vectoresPerpendiculares() {
        System.out.println("Usted ha selecionado la opcion 6, verificar vectores perpendiculares.");
        System.out.println("Salida:\n");

        if ((x * x1) + (y * y1) + (z * z1) == 0) {
            System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} si son perpendiculares.");
        } else {
            System.out.println("V1 {" + x + ", " + y + ", " + z + "} y V2 {" + x1 + ", " + y1 + ", " + z1 + "} no son perpendiculares.");
        }

    }

    private static void mostrarVectores() {
        System.out.println("Usted ha seleccionado la opción 7, mostrar vectores.");
        System.out.println("Salida:\n");

        System.out.println("V1 {" + x + ", " + y + ", " + z + "}");
        System.out.println("V2 {" + x1 + ", " + y1 + ", " + z1 + "}");

    }

    private static void escalarVectores() {
        System.out.println("Usted ha seleccionado la opción 11, escalar vectores.");
        System.out.print("Ingrese el numero: ");

        double numero = scan.nextDouble();

        v1[0] = (numero * x);
        v1[1] = (numero * y);
        v1[2] = (numero * z);

        v2[0] = (numero * x1);
        v2[1] = (numero * y1);
        v2[2] = (numero * z1);

        System.out.println("Salida:");
        System.out.println("\nLos vectores fueron escalados.");
        System.out.println("\nV1 {" + v1[0] + ", " + v1[1] + ", " + v1[2] + "}");
        System.out.println("V2 {" + v2[0] + ", " + v2[1] + ", " + v2[2] + "}");

    }

    private static void invertirVectores() {

        System.out.println("Usted ha seleccionado la opción 12, time parser.");
        System.out.print("Ingrese la cantidad de minutos: ");
        int minutos = scan.nextInt();
        System.out.println("Salida:");

        double[] v3 = new double[3];
        v3[0] = (x);
        v3[1] = (y);
        v3[2] = (z);

        x = x1;
        y = y1;
        z = z1;

        x1 = v3[0];
        y1 = v3[1];
        z1 = v3[2];

        System.out.println("\nLos vectores se han intercambiado.");
        System.out.println("\nV1 {" + x + ", " + y + ", " + z + "}");
        System.out.println("V2 {" + x1 + ", " + y1 + ", " + z1 + "}");

    }

    private static void normalizarVectores() {
        System.out.println("Uste ha seleccionado la opción 13, normalizar vectores.");
        System.out.println("Salida:");

        double a = ((x * x) + (y * y) + (z * z));
        double b = ((x1 * x1) + (y1 * y1) + (z1 * z1));

        x = (x / Math.sqrt(a));
        y = (y / Math.sqrt(a));
        z = (z / Math.sqrt(a));

        x1 = (x1 / Math.sqrt(b));
        y1 = (y1 / Math.sqrt(b));
        z1 = (z1 / Math.sqrt(b));

        System.out.println("\nLos vectores se han normalizado.");
        System.out.println("\nV1 {" + x + ", " + y + ", " + z + "}");
        System.out.println("V2 {" + x1 + ", " + y1 + ", " + z1 + "}");

    }

    private static void bonoOpcion() {
        System.out.println("Usted ha seleccionado la opción 14, imprimir V1.");
        System.out.println("\nV2 {" + x1 + ", " + y1 + ", " + z1 + "}");

        double a = Math.abs(x1);
        double b = Math.abs(y1);
        double c = Math.abs(z1);

        double a1 = Math.floor(x1);
        double b1 = Math.floor(y1);
        double c1 = Math.floor(z1);

        System.out.println("\nSalida:\n");

        if (x1 < 0) {

            for (int i = 0; i < a; i++) {
                System.out.println("{" + x + ", " + y + ", " + z + "}");
            }
        } else if (x1 >= 0) {
                System.out.println("");

                for (int i = 0; i < a1; i++) {
                    System.out.println("{" + x + ", " + y + ", " + z + "}");
                }
            }

            if (y1 < 0) {
                System.out.println("");
                for (int i = 0; i < b; i++) {
                    System.out.println("{" + x + ", " + y + ", " + z + "}");
                }
            } else if (y1 >= 0) {
                System.out.println("");
                for (int i = 0; i < b1; i++) {
                    System.out.println("{" + x + ", " + y + ", " + z + "}");
                }
            }

            if (z1 < 0) {
                System.out.println("");
                for (int i = 0; i < c; i++) {
                    System.out.println("{" + x + ", " + y + ", " + z + "}");
                }
            } else if (z1 >= 0) {
                System.out.println("");
                for (int i = 0; i < c1; i++) {
                    System.out.println("{" + x + ", " + y + ", " + z + "}");
                }
            }

        }
    }

