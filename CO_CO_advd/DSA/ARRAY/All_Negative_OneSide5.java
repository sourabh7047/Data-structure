package DSA.ARRAY;


import java.util.Scanner;

public class All_Negative_OneSide5 {
    public static int[] oneside(int[] arr, int n){
        int start = 0; int end = n-1;
        while(start !=end && start<end){
            if(arr[start] >=0) {
                if(arr[end]<0) arr[end] = arr[start]+arr[end]-(arr[start]=arr[end]);
                else end--;
            }
            else start++;
            
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n; i++){
                arr[i] = sc.nextInt();
            }

            oneside(arr, n);
            for(int x: arr) System.out.print(x+ " ");
        }
    }
}
