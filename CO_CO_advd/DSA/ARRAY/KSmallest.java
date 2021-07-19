package DSA.ARRAY;

import java.util.Arrays;
import java.util.Scanner;

public class KSmallest {
    static int kSmallestElement(int arr[], int initial,int end, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();

            int arr[] = new int[n];

            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            
            int k = sc.nextInt();
            System.out.println(kSmallestElement(arr, 0, n-1,k));
            

        }
    }
}
