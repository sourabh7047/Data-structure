package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class longest_repeating_substring {
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
        String str = sc.next();

        System.out.println(LongestRepeatingSubsequence(str));
    }

    public static int LongestRepeatingSubsequence(String str1) {
        // code her

        int[][] dp = new int[str1.length() + 1][str1.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[i].length - 2; j >= 0; j--) {
                if (str1.charAt(i) == str1.charAt(j) && i != j) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

       return dp[0][0];
    }
}
