package codechef.Codechef_june_cookoff;

import java.util.*;
import java.lang.*;
import java.io.*;

public class code_test {
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
        long t = sc.nextLong();

        while (t-- > 0) {
            int n = sc.nextInt();
            

            
            int[] master = new int[n];
            

            for (int i = 0; i < n; i++) {
                master[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int finala = bs(master, target, 0, n-1);
            System.out.println(finala);

        }
    }
    public static int bs(int[] roots, int target, int rs, int re) {

        while (rs <= re) {
            int middle = (rs + re) / 2;
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
