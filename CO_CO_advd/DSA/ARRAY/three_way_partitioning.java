package DSA.ARRAY;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class three_way_partitioning {

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
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] output = threeWayPartition(array, a, b);

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }

    public static int[] threeWayPartition(int array[], int a, int b) {
        // code here
        int start = 0;
        int end = array.length - 1;
        int temp = 0;

        while (temp < end + 1) {
            if (array[start] < a) {
                start = temp = start + 1;
            } else if (array[end] > b) {
                end = end - 1;
            } else {
                if (array[end] < a) {
                    array[start] = array[start] + array[end] - (array[end] = array[start]);
                    start++;
                    if (start > temp)
                        temp = start;
                } else if (array[temp] < a) {
                    array[temp] = array[start] + array[temp] - (array[start] = array[temp]);
                    start++;
                    temp++;
                } else if (array[temp] > b) {
                    array[temp] = array[end] + array[temp] - (array[end] = array[temp]);
                    temp++;
                    end--;

                } else {
                    temp++;
                }
                // Arrays.sort(a); although they have given the time complexity to be O(n) still!
            }
        }
        return array;

    }
}
