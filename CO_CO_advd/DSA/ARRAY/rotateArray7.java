package DSA.ARRAY;

import java.util.Scanner;

public class rotateArray7 {

    static long[] rotate(long[] arr, long n){
        long end = arr[(int) (n - 1)];
        for(int i= (int) (n - 1); i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = end;
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];

            for(int i=0;i<n;i++) arr[i] =sc.nextInt();

            rotate(arr, n);
            for(long x: arr) System.out.print(x+ " ");
            System.out.println();
        }
    }
}
