package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class pair_equal_to_sum {

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
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getPairCount(arr, n, k));

    }

    public static int getPairCount(int arr[], int n, int k) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1, sum1, sumcount = 0;
        while (i != j) {
            sum1 = arr[i] + arr[j];

            if (sum1 == k) {
                sumcount += 1;
                if (j > i + 1) {

                    for (int a = i + 1; a < j; a++) {
                        if (arr[a] == arr[i] || arr[a] == arr[j]) {
                            sumcount += 1;
                        }
                    }
                }
                i++;
                j--;

            } else if (sum1 > k) {
                j--;
            } else if (sum1 < k) {
                i++;
            }
        }

        return sumcount;
    }

}
