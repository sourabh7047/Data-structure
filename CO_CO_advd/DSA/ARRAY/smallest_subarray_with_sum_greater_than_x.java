package DSA.ARRAY;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class smallest_subarray_with_sum_greater_than_x {
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
        long n = sc.nextLong();

        long[] a = new long[(int) n];

        for (int i = 0; i < n; i++) {
                a[i]= sc.nextLong();
        }

        long x = sc.nextLong();

        long min_diff = sb(a, n, x);
        System.out.println(min_diff);
    }

    public static long sb(long a[], long n, long X) {
        int start =0;
        int end =0;
        long local_sum =0;
        int diff = 0;
        int min_diff =Integer.MAX_VALUE;
        while(end< a.length){
            if(local_sum<=X){
                local_sum = local_sum +a[(int)end++];
            }

            while(local_sum>X){
                diff = end-start;
                if(diff<min_diff){
                    min_diff = diff;
                }
                local_sum = local_sum - a[(int)start++];
            }
        }
        return min_diff;
    }
}
