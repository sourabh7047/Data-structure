package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Set;

public class check_subarray {
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
        long n = sc.nextInt();
        long m = sc.nextInt();

        long[] a1 = new long[(int)n];
        long[] a2 = new long[(int)m];

        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            a2[i] = sc.nextInt();
        }
    }

    public static String isSubset(long a1[], long a2[], long n, long m) {
       Set<Long> element  = new HashSet<>();

       for(int i=0; i<n; i++){
           element.add(a1[i]);
       }

       for(int i=0; i<n; i++){
           if(!element.contains(a2[i])){
                return "No";
           } 
       }

       return "Yes";

    } 
}
