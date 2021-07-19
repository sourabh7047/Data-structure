package codechef.april_comp_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Set;

public class solution4 {
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

            long n = sc.nextInt();
            long q = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt()); 
            }
            while (q-- > 0) {

                long x= sc.nextLong();
                long v = sc.nextLong();

                if(arr.size()-1<x){
                    arr.add((int)x);
                }else {
                    arr.add((int)x,(int)v);
                }


                ArrayList<Integer> sa = new ArrayList<>();

                long opsize = (int) Math.pow(2, n);

                /* Run from counter 000..1 to 111..1 */
                ArrayList<Integer> temp = new ArrayList<>();
                for (int counter = 1; counter < opsize; counter++) {
                    for (int j = 0; j < n; j++) {
                        /*
                         * Check if jth bit in the counter is set If set then print jth element from
                         * arr[]
                         */
                        if (BigInteger.valueOf(counter).testBit(j)) {
                            temp.add((int)arr.get(j));
                        }
                    }
                    long score = temp.get(0);

                    for (int i = 0; i < temp.size(); i++) {
                        score = (score & temp.get(i));
                    }

                    sa.add((int)score);

                    // clearing temp to get new subarray
                    temp.clear();
                }
                int obs = sa.get(0);
                for (int i = 1; i < sa.size(); i++) {
                    obs = (obs | sa.get(i));
                }

                System.out.println(obs);
            }

        }
    }
}
