package codechef.codechef_compi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class solution14 {
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
            String s = sc.next();
            StringBuilder str = new StringBuilder(s);


            int ic; int fc; int diff;

            int[] charge = new int[k];

            for (int i = 0; i < k; i++) {
                charge[i] = sc.nextInt();
            }

            //
            int tc = 0;

            for (int i = 1; i < n; i++) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    tc += 2;
                } else {
                    tc += 1;
                }
            }

            //
            for (int i = 0; i < k; i++) {
                 ic = 0;
                 fc = 0;
                 diff = 0;
                if (charge[i] != 1 && charge[i] != n) {
                    for (int j = charge[i] - 2; j < charge[i]; j = j + 1) {
                        if (str.charAt(j) == str.charAt(j + 1)) {
                            ic += 2;
                        } else {
                            ic += 1;
                        }
                    }

                    if (str.charAt(charge[i] - 1) == '0') {
                        str.setCharAt(charge[i] - 1, '1');

                    } else {
                        str.setCharAt(charge[i] - 1, '0');
                    }

                    for (int j = charge[i] - 2; j < charge[i]; j = j + 1) {
                        if (str.charAt(j) == str.charAt(j + 1)) {
                            fc += 2;
                        } else {
                            fc += 1;
                        }
                    }
                } else {
                    if (charge[i] == 1) {
                        if (str.charAt(0) == str.charAt(1)) {
                            ic += 2;
                        } else {
                            ic += 1;
                        }

                        if (str.charAt(charge[i] - 1) == '0') {
                            str.setCharAt(charge[i] - 1, '1');

                        } else {
                            str.setCharAt(charge[i] - 1, '0');
                        }

                        if (str.charAt(0) == str.charAt(1)) {
                            fc += 2;
                        } else {
                            fc += 1;
                        }
                    } else {
                        if (str.charAt(n - 1) == str.charAt(n - 2)) {
                            ic += 2;
                        } else {
                            ic += 1;
                        }

                        if (str.charAt(charge[i] - 1) == '0') {
                            str.setCharAt(charge[i] - 1, '1');

                        } else {
                            str.setCharAt(charge[i] - 1, '0');
                        }

                        if (s.charAt(n - 1) == s.charAt(n - 2)) {
                            fc += 2;
                        } else {
                            fc += 1;
                        }
                    }
                }

                diff = fc - ic;
                tc = tc + diff;
                System.out.println(tc);
            }

        }
    }
}