package codechef.Codechef_june_cookoff;

import java.util.*;
import java.lang.*;
import java.io.*;

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
        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            long c0 = 0;
            long c1 = 0;
            long max = Integer.MAX_VALUE;
            long diff,count=0;

            String s = sc.next();

            // s.toCharArray();
            for(int i=0; i<n; i++){
                if(s.charAt(i) == 0){
                    c0++;
                } else {
                    c1++;
                }
            }

            c0 = c0/ratio(c0, c1);
            c1 = c1/ratio(c0, c1);

            

            for(int i=0; i<n; i++){
                if(s.charAt(i) == 1){
                    if(i>max){
                        diff = i-max;
                        if(diff == c0){
                            count++;
                        } else {

                        }
                    } else {
                        max = i;
                    }
                }
            }

            System.out.println(c1-count);
        }

    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
    
    public static long ratio(long a, long b) {
       final long gcd = gcd(a,b);
       return gcd;
    }
}
