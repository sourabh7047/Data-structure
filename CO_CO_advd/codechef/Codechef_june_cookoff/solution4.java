package codechef.Codechef_june_cookoff;

import java.util.*;
import java.lang.*;
import java.io.*;

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
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long count=0;
            String string;

           

            for (int i = 0; i < n; i++) {
                string = sc.next();
                for(int j=0; j<m; j++){
                    count += string.charAt(j)-'0';
                }
            }

            if(count%2 ==0){
                System.out.println("no");
            } else {
                System.out.println("yes");
            }

            
        }
    }
}
