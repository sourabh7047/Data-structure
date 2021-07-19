package DSA.ARRAY;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class minimum_swaps_and_k_together {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public char nextChar() {
            return next().toCharArray()[0];
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minSwap(arr, n, k));
    }

    public static int minSwap(int arr[], int n, int k) {
        // Complete the function
        int telek = 0;
        int wtelek = 0;
        int nwtelek = 0;
        int ws = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                telek++;
            }
        }
        int we = telek;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k && i < we) {
                wtelek++;
            }
            if (i == we - 1) {
                nwtelek = wtelek;

            }

            if (i > we - 1) {

                if (arr[ws] <= k) {
                    nwtelek = nwtelek - 1;
                    ws += 1;
                } else {
                    ws += 1;
                }

                if (arr[i] <= k) {
                    nwtelek += 1;
                }

                if (nwtelek > wtelek) {
                    wtelek = nwtelek;
                }

            }

        }

        return telek - wtelek;

    }
    // int j=0;
    // int swaps = 0;
    // int prev_index=0;
    // int diff;
    // while(j<n){
    // if(arr[j]<=k){
    // prev_index=j;

    // break;
    // }
    // j++;
    // }
    // while(++j<n){
    // if(arr[j]<=k){
    // diff = j - prev_index;

    // prev_index = j;

    // if(diff>1) swaps++;
    // }

    // }
    // return swaps;
}
