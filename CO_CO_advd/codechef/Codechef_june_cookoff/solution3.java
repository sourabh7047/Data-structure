package codechef.Codechef_june_cookoff;

import java.util.*;
import java.lang.*;
import java.io.*;

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

    public static long bs(long[] roots, long target, long rs, long re) {

        while (rs <= re) {
            long middle = (rs + re) / 2;
            if (target == roots[(int) middle]) {
                return (int) middle;
            } else if (target > roots[(int) middle]) {
                rs = middle + 1;
            } else if (target < roots[(int) middle]) {
                re = middle - 1;
            }
        }
        return rs;

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        long n = sc.nextLong();
        long q = sc.nextLong();
        long counter = 0;
        long comp;
        boolean isit = false;

        long[] roots = new long[(int) n];
        ;
        long[] queries = new long[(int) q];

        for (int i = 0; i < n; i++) {
            roots[i] = sc.nextLong();

        }

        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextLong();
        }

        Arrays.sort(roots);

        for (int i = 0; i < q; i++) {
            
            long position = bs(roots, queries[i], 0, roots.length-1);

            if (position <n && roots[(int)position] == queries[i] ) {
                System.out.println(0);
            } else if (position%2 == 0) {
                System.out.println("POSITIVE");
                counter = 0;
            } else {
                System.out.println("NEGATIVE");
                counter = 0;
            }
        }
    }

    public static long bs(long[] roots, long target, long rs, long re) {

        while (rs <= re) {
            long middle = (rs + re) / 2;
            if (target == roots[(int) middle]) {
                return (int) middle;
            } else if (target > roots[(int) middle]) {
                rs = middle + 1;
            } else if (target < roots[(int) middle]) {
                re = middle - 1;
            }
        }
        return rs;

    }
}
