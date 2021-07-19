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

import DSA.codechef_june.mahajan.FastReader;

public class bella_ciou {
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
            int D = sc.nextInt();
            int d = sc.nextInt();
            int P = sc.nextInt();
            int Q = sc.nextInt();

            int multidays  = D/d;
            int sumrem = D%d;

            long print = D*P + d*Q*((multidays*(multidays-1))/2) + sumrem*(multidays)*Q;
            System.out.println(print);
        }
    }
}
