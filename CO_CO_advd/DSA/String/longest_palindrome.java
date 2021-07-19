package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class longest_palindrome {
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
        String s = sc.next();

        System.out.println(palindrome(s));

    }

    public static String palindrome(String s) {
        String tempR = String.valueOf(s.charAt(0)), temp2 = "", temp3 = "";
        int mf, mb;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                mf = i + 1;
                mb = i;
                temp2 = String.valueOf(s.charAt(mb)) + String.valueOf(s.charAt(mf));

                while (--mb >= 0 && ++mf < s.length()) {
                    if (s.charAt(mb) == s.charAt(mf)) {
                        temp2 = String.valueOf(s.charAt(mb)) + temp2 + String.valueOf(s.charAt(mf));
                    } else
                        break;
                }
                if (temp2.length() > tempR.length()) {
                    tempR = temp2;
                }
            }

            // part 2
            if (i > 0) {

                mb = i - 1;
                mf = i + 1;
                if (s.charAt(mb) == s.charAt(mf)) {
                    temp3 = String.valueOf(s.charAt(mb)) + String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(mf));

                    while (--mb >= 0 && ++mf < s.length()) {
                        if (s.charAt(mb) == s.charAt(mf)) {
                            temp3 = String.valueOf(s.charAt(mb)) + temp3 + String.valueOf(s.charAt(mf));
                        } else {
                            break;
                        }
                    }

                    if (temp3.length() > tempR.length()) {
                        tempR = temp3;
                    }
                }
            }
        }

        return tempR;
    }
}
