package DSA.String;

import java.util.Scanner;

import org.graalvm.compiler.graph.spi.Canonicalizable.Binary;

public class binary_exponentiation {
    static int power(int x, int y, int p) {
        int res = 1;
        x = x % p;

        if (x == 0) {
            return 0;
        }
        while (y > 0) {
            if ((y & 1) != 0) {
                res = (res * x) % p;
                y = y >> 1;
                x = (x * x) % p;
            }
            System.out.print("s ");
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        while(b>0){
            System.out.print(b+ " ");
            System.out.print(b%2+" ");
            System.out.println(b/2);
            b /=2;
        }
    }

}
