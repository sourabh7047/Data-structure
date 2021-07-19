package DSA.String;

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
import javax.print.DocFlavor.STRING;

import jdk.javadoc.internal.doclets.toolkit.taglets.ReturnTaglet;

import java.util.Random;
import java.util.Stack;

public class count_say {
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
        int n = sc.nextInt();

        System.out.println(CountAndSay(n));
    }

    public static String CountAndSay(int n) {
        String s = "", ts = "";
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        else {
            int i = n;
            s = "11$";
            while (i-- > 2) {
                ts = "";
                int t = 0, count = 1;
                while (++t < s.length()) {
                    if (s.charAt(t) == s.charAt(t - 1)) {
                        count += 1;
                    } else {
                        ts += Integer.toString(count) + s.charAt(t - 1);
                        count = 1;
                    }
                }

                if (i == 2) {
                    s = ts;
                } else {
                    s = ts + "$";
                }
            }

        }
        return s;
    }
}

// public static String CountAndSay(int n) {
// int i = 1, intreper;
// String ms = "1";
// Map<Integer, Integer> count = new
// TreeMap<Integer,Integer>(Collections.reverseOrder());

// if (n == 1) {
// return ms;
// } else {
// while (i++ < n) {

// // updating hashmap
// for(int j=0; j<ms.length(); j++){
// intreper = Integer.parseInt(String.valueOf(ms.charAt(j)));

// if(!count.containsKey(intreper)){
// count.put(intreper, 1);
// } else {
// count.put(intreper, count.get(intreper)+1);
// }
// }

// // building string ms again
// ms = "";
// for (Map.Entry<Integer,Integer> entry : count.entrySet() ) {
// ms += Integer.toString(entry.getValue()) + Integer.toString(entry.getKey());
// }
// count.clear();
// }
// return ms;
// }
// }