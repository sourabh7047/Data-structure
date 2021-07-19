package DSA.String;

import java.util.*;
import java.io.*;

public class string_in_a_grid {
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
            int m = sc.nextInt();

            char[][] nextCharac = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nextCharac[i][j] = sc.nextChar();
                }
            }

            String str = sc.next();

            int[][] cordi = searchWord(nextCharac, str);
            for (int i = 0; i < cordi.length; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(cordi[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static int[][] searchWord(char[][] nextCharac, String str) {
        // Code here
        Stack<int[]> cordinate = stringCount(nextCharac, str);
        int[][] coordi = new int[cordinate.size()][2];

        int i = 0, n = cordinate.size();

        while (i < n) {
            coordi[i][0] = cordinate.peek()[0];
            coordi[i][1] = cordinate.peek()[1];
            cordinate.pop();
            i++;
        }

        return coordi;

    }

    static int[] diri = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dirj = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static Stack<int[]> stringCount(char[][] nextCharac, String str) {

        for (int i = 0; i < nextCharac.length; i++) {
            for (int j = 0; j < nextCharac[0].length; j++) {
                if (nextCharac[i][j] == str.charAt(0)) {
                    if (search(nextCharac, i, j, str, 1) == 1) {

                        // System.out.println(i + " " + j + "/");
                        coordinates.push(new int[] { i, j });
                        // break;
                    }
                }
            }
        }

        return coordinates;
    }

    static Stack<int[]> coordinates = new Stack<>();

    static int search(char[][] nextCharac, int row, int column, String str, int index) {
        int newr, newc;
        if (index == str.length()) {
            return 1;
        }

        if (index < str.length()) {
            for (int i = 0; i < diri.length; i++) {
                newr = row + diri[i];
                newc = column + dirj[i];
                if ((newr >= 0 && newc >= 0 && newr < nextCharac.length && newc < nextCharac[0].length)) {
                    if (nextCharac[newr][newc] == str.charAt(index)) {
                        if (trivial_search(nextCharac, newr, newc, diri[i], dirj[i], str, index + 1) == 1) {
                            // System.out.println(newr + " " + newc + "/");
                            // coordinates.push(new int[] { newr, newc });
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    static int trivial_search(char[][] nextCharac, int row, int column, int diri, int dirj, String str, int index) {
        int newr, newc;
        if (index == str.length()) {
            return 1;
        }

        if (index < str.length()) {
            newr = row + diri;
            newc = column + dirj;
            if ((newr >= 0 && newc >= 0 && newr < nextCharac.length && newc < nextCharac[0].length)) {
                if (nextCharac[newr][newc] == str.charAt(index)) {
                    if (trivial_search(nextCharac, newr, newc, diri, dirj, str, index + 1) == 1) {
                        // System.out.println(newr + " " + newc + "/");
                        // coordinates.push(new int[] { newr, newc });
                        return 1;
                    }

                }
            }
        }

        return 0;
    }

}
