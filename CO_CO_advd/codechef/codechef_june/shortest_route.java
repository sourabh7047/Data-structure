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

public class shortest_route {

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
            return Long.parseLong(next());        }

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
            int m = sc.nextInt();

            int[] trains = new int[n];
            int[] forward = new int[n];
            int[] backward = new int[n];
            int[] passengers = new int[m];

            int mr = -1;
            for (int i = 0; i < n; i++) {
                trains[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                passengers[i] = sc.nextInt();
            }
            // filling up forward array
           
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    forward[0] = 0;
                    if (trains[0] == 1) {
                        mr = i;
                    }
                } else if (trains[i] == 1) {
                    forward[i] = 0;
                    mr = i;
                } else if (mr == -1) {
                    forward[i] = Integer.MAX_VALUE;
                } else {
                    forward[i] = i - mr;
                }
            }
           

            // filling up backward array
            mr = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (trains[i] == 2) {
                    backward[i] = 0;
                    mr = i;
                } else if (mr == -1) {
                    backward[i] = Integer.MAX_VALUE;
                } else {
                    backward[i] = mr - i;
                }
            }

            

            int result;
            for (int i = 0; i < m; i++) {
                result = Math.min(forward[passengers[i] - 1], backward[passengers[i] - 1]);
                if (result == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(result);
                }
            }

        }
    }

}
