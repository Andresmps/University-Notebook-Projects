package pascal_triangulo;

import java.util.Scanner;

/**
 *
 * @author camilo
 */
public class Pascal_Triangulo {

    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        double N = scan.nextLong();
        System.out.println( (int) sumatoria(N));
    }
    
    public static double sumatoria(double n){
        
        if(n == 1) return 1;

        return Math.pow(2, n-1) + sumatoria(n-1); 
    }
}
