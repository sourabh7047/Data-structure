package DSA.codechef_june;

import java.util.Scanner;

public  class summer_heat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int M=  sc.nextInt();
            int N = sc.nextInt();

            System.out.println((M/m)+ (N/n));
        }
    }
}
