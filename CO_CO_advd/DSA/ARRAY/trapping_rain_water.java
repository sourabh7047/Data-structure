package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class trapping_rain_water {
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

        System.out.println(trappingWater(arr, n));
    }

    static int trappingWater(int arr[], int n) {

        // Your code here
        int[] maxp = new int[n];
        int[] maxa = new int[n];
        int tm = Integer.MIN_VALUE;

        for(int i=0; i<n ; i++){
            if(arr[i]> tm){
                tm = arr[i];
                maxp[i] = tm;
            } else {
                maxp[i] = tm;
            }
        }
        tm = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i]>tm){
                tm = arr[i];
                maxa[i] = tm;
            }else {
                maxa[i] = tm;
            }
        }

        int min =0;
        int score =0;
        for(int i=0; i<n; i++){
            min = Math.min(maxp[i], maxa[i]);
            score = score + (min-arr[i]);
        }
        
        return score;
    }
}
