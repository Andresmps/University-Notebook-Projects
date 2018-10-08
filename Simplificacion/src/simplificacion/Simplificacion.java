package simplificacion;

import java.util.Scanner;

/**
 *
 * @author CISCO
 */
public class Simplificacion {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(doeneris(scan.nextInt()));
    }

    public static int doeneris(int numero) {

        if (numero == 1 || numero == 2) {
            return numero*2;
        }
        return doeneris(numero-1)+numero;
    }

}
