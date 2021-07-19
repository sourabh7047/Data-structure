package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class triple_sum_in_array {
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
        int X = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(find3Numbers(arr, n, X));
    }

    public static boolean find3Numbers(int A[], int n, int X) {

        // Your code Here
        Arrays.sort(A);
        boolean sl = false;
        boolean output = false;

        for (int i = 0; i < n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            int vr = X - A[i];
            while (j != k) {
                if (A[j] + A[k] == vr) {
                    output = !output;
                    sl = !sl;
                    break;
                } else if (A[j] + A[k] > vr)
                    k--;
                else if (A[j] + A[k] < vr)
                    j++;
            }
            if(sl) break;

        }
        if (output) return true;
         else return false;
        

    }
}
