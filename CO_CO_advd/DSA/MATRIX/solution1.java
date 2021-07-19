package DSA.MATRIX;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Random;
import java.util.Set;

public class solution1 {
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
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String[] test = new String[k];

            for (int i = 0; i < k; i++) {
                test[i] = sc.next();
            }
            //
            int c1 = 0;
            int c2 = 0;
            int total =0;

            int[] counter = new int[k];

            for (int i = 0; i < k; i++) {

                for (int j = 0; j < test[i].length(); j++) {
                    if (test[i].charAt(j) >= 'a' && test[i].charAt(j) <= 'm') {
                        c1++;
                    } else if (test[i].charAt(j) >= 'N' && test[i].charAt(j) <= 'Z') {
                        c2++;
                    }
                }

                if (c1 == test[i].length() || c2 == test[i].length()) {
                    counter[i]=1;
                } else {
                    counter[i] =0;
                }

            }

            for(int x: counter){
                total += x;
            }

            if( total == k){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }


        }
    }

}
