package DSA.ARRAY;

import java.util.Arrays;
import java.util.Scanner;



public class Minimize_Th_Heights_II9 {

    static int getMinDiff(int arr[], int n, int k) {
        for (int i = 0; i < n; i++) {
            if(arr[i]<=0){
                arr[i] = arr[i]+k;
            } else if((arr[i]-k)>0){
                arr[i] = arr[i]-k;
            } else if((arr[i]-k)<=0){
                arr[i]= arr[i]+k;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[n-1]+" "+arr[0]);
        return Math.abs((arr[n-1]-arr[0]));
    }


    // static int getMinDiff(int arr[], int n, int k) {
    //     Arrays.sort(arr);
    //     int lowest=0, highest=0;
    //     int lowest_index=0, highest_index=0;
    //     if (n == 1) {
    //         return 0;
    //     } else {
    //         for (int i = 0; i < n; i++) {
    //             lowest = arr[i] + k;
    //             lowest_index = i;
    //             if (lowest >= 0) break;
    //         }
    //         for (int j = n - 1; j >= 0; j--) {
    //             highest = arr[j] - k;
    //             highest_index = j;
    //             if (highest >= 0) break;
    //         }
    //     }
        
    //     if(lowest_index == highest_index) return 0;
    //     else return (int)Math.abs(highest-lowest);

    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.println(getMinDiff(arr, n, k)); 
            
        }

    }
}
