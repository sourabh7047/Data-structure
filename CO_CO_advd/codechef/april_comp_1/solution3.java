package codechef.april_comp_1;

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

public class solution3 {
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
        int p = sc.nextInt();

        while(p-->0){
            long n = sc.nextInt();
            long r = sc.nextInt();
            
            long[] A = new long[(int)n];
            long[] B = new long[(int)n];

            for(int i=0;i<n; i++){
                A[i] = sc.nextInt();
            }

            for(int i=0;i<n; i++){
                B[i] = sc.nextInt();
            }
            long t = B[0];
            long tmax = B[0];
            for(int i=1;i <n; i++){
                t = t - (A[i]-A[i-1])*r;
                if(t<0){
                    t =0;
                }
                if(t>tmax){
                    tmax = t;
                }
                t = t+B[i];
                if(t>tmax){
                    tmax = t;
                }
            }
            if(tmax<0){
                tmax =0;
            }
            System.out.println(tmax);
        }
    }
    
}
