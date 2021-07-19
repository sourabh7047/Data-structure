package DSA.ARRAY;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class maximum_product_subarray {
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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProduct(arr, n));
    }

    static long maxProduct(int[] arr, int n) {
        // code here
        long minVal = arr[0];
        long maxVal = arr[0];

        long maxPro = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                long temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            if (maxVal == 0)
                maxVal = 1;
            if (minVal == 0)
                minVal = 1;

            if (maxVal > maxPro) {
                maxPro = maxVal;
            }
        }
        return maxPro;
    }
}
