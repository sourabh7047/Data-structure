package codechef.codechef_compi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class solution13 {
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
            int n = sc.nextInt();
            int k = sc.nextInt();
            int c1 = 0;
            int c2 = 0;

            ArrayList<Integer> gifts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                gifts.add(sc.nextInt());
            }
            Collections.sort(gifts, Collections.reverseOrder());

            // first person
            int counter1 = k;
            int mult = 0;
            while (counter1-- > 0) {
                c1 = c1 + gifts.get(mult);
                mult = mult + 2;
            }

            // second contestent
            int counter2 = k;
            int mult2 = 1;
            while (counter2-- > 0) {
                c2 = c2 + gifts.get(mult2);
                mult2 = mult2 + 2;
            }
            c2 += gifts.get(mult2 - 1);

            int max = Math.max(c1, c2);
            System.out.println(max);
        }
    }
}