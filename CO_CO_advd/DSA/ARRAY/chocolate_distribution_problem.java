package DSA.ARRAY;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class chocolate_distribution_problem {
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
        long n = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add((long) sc.nextInt());
        }
        long m = sc.nextInt();


        System.out.println(findMinDiff(a, n, m));
    }

    public static long findMinDiff(ArrayList<Long> a, long n, long m) {
        // your code here
        Collections.sort(a, Collections.reverseOrder());
        for(int i=0; i<n; i++){
            System.out.print(a.get(i)+" ");
        } 
        System.out.println();
        if (m == 0) {
            return 0;
        } else if (m == a.size()) {
            return a.get(0) - a.get((int)n - 1);
        } else {
            long diff = Integer.MAX_VALUE;
            long current_diff;
            for (int i = 0; i < a.size() - (m-1); i++) {
                current_diff = a.get((int) m-1 + i) - a.get(i);
                if (diff > current_diff)
                    diff = current_diff;
            }
            return diff;
        }
    }

}