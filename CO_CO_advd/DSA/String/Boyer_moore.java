package DSA.String;

import java.util.*;
import java.io.*;

public class Boyer_moore {
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
        String text = "promethous is the story of how human discover their creater and how an android become a new god";
        String pattern = "god";

        System.out.println(findBoyerMoore(text, pattern));

    }

    
    public static int findBoyerMoore(String text, String pattern) {
        int txtlen = text.length();
        int patlen = pattern.length();

        // test for empty String
        if (patlen == 0)
            return 0;

        // initialisation
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < txtlen; i++) {
            last.put(text.charAt(i), -1); // set all character by default to -1
        }

        for (int i = 0; i < patlen; i++) {
            last.put(pattern.charAt(i), i);
        }

        for (Map.Entry<Character, Integer> entry : last.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();

        int tIdx = patlen - 1;
        int pIdx = patlen - 1;

        while (tIdx < txtlen) {
            if (text.charAt(tIdx) == pattern.charAt(pIdx)) {
                if (pIdx == 0)
                    return tIdx;
                tIdx--;
                pIdx--;
            } else {
                tIdx += patlen - Math.min(pIdx, 1 + last.get(text.charAt(tIdx)));
                pIdx = patlen - 1;
            }
        }

        return -1;
    }
}
