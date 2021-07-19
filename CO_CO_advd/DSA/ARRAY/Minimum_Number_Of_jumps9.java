package DSA.ARRAY;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Minimum_Number_Of_jumps9 {

    static int jumping(int arr[], int n) {
        ArrayList<Integer> arr_list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            arr_list.add(arr[i]);
        }

        int i=1;
        int fix=arr[0];
        int count= fix;
        int jumps=0;
        int max=Integer.MIN_VALUE;
        while(i<n){
            if(count >= n){
                System.out.println(count);
                break;
            }
            
            if(arr_list.get(i)>=max && i<=fix){
                System.out.println(i);
                max = arr_list.get(i);
            }

            if(i == fix){
                count += max;
                jumps++;
                i = arr_list.indexOf(max);
                fix = arr_list.indexOf(max) + max;
                max = Integer.MIN_VALUE;
            }
            i++;
        }    
        return jumps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] arr = {4,7,5,1,8,2,2,3,1,1,1,1,1,1,1};
            System.out.println(jumping(arr, arr.length));
        }
           

    }
}
