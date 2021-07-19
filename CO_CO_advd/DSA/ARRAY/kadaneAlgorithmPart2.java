package DSA.ARRAY;

import java.util.Scanner;

public class kadaneAlgorithmPart2 {
    static void maxsumArray(int[] arr, int n) {
        int global_max = 0;
        int local_max = 0;
        int start=0, end;
        int name=0, surname=0;
        
        for (int i = 0; i < n; i++) {
            local_max += arr[i];
            if (local_max > global_max) {
                global_max = local_max;
                name = start;
                end = i;
                surname = i;
            }
            if (local_max < 0 ) {
                local_max = 0;
                start = i + 1;

            }
            // either this can be done or we can compare the value of i with the end of the array and can compare gs with ge
            if (local_max < global_max) {
                end = i;
            }
        }

        for (int j = name; j <= surname; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();
            maxsumArray(arr, n);
        }
    }
}
