
package count_numbers;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author camilo
 */
public class Count_Numbers {

    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        BigInteger N = new BigInteger(scan.nextLine());
        System.out.println(contarCifras(N));
    }
    //1234
    //9223372036854775807
    public static BigInteger contarCifras(BigInteger n){
        if( n.longValue() > -10 && n.longValue() < 10) return BigInteger.ONE;
        
        return BigInteger.ONE.add(contarCifras(n.divide(new BigInteger("10"))));
    }

    
}
