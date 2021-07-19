package DSA.codechef_june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Stack;

public class bitwise_tuples {
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
            long n = sc.nextLong();
            long m = sc.nextLong();

            long a = exponential(2, n)-1;
            long result = exponential(a, m);
            System.out.println(result);
            
        }
    }

    public static long exponential(long p, long m){
        long result = 1;
        long modulus = 1000000007;
            while(m>0){
                if(m%2==1){
                    result = (result*p)%modulus;
                }
                p =  (p*p)%modulus;
                m =m/2;
            }
            return result;
    }
}
