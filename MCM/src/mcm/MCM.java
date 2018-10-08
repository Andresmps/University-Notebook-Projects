
package mcm;

import java.util.Scanner;

/**
 *
 * @author camilo
 */
public class MCM {

    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        long a = scan.nextLong();
        long b = scan.nextLong();
        System.out.println(numeroMayor(a, b));
    }
    
    public static long mcm(long a, long b){
        
        return (a*b)/mcd(a,b);
        
    }
    
    public static long mcd(long a, long b){
        
        if(b == 0) return a;
        
        return mcd(b, a % b);
    }
    
    public static long numeroMayor(long a, long b){
        
        if(a > b) return mcm(a,b);
        
        return mcm(b,a);
    }
    
}
