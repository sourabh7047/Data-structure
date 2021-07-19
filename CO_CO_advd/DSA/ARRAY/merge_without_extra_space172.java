package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class merge_without_extra_space172 {
    static void ruffleSort(int[] a) {
        Random random = new Random();
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        Random random = new Random();
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void reverse(int[] arr, int l, int r) {
        for (int i = l; i < l + (r - l) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[r - i + l - 1];
            arr[r - i + l - 1] = temp;
        }
    }

    static void reverse(long[] arr, int l, int r) {
        for (int i = l; i < l + (r - l) / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[r - i + l - 1];
            arr[r - i + l - 1] = temp;
        }
    }

    static <T> void reverse(T[] arr, int l, int r) {
        for (int i = l; i < l + (r - l) / 2; i++) {
            T temp = arr[i];
            arr[i] = arr[r - i + l - 1];
            arr[r - i + l - 1] = temp;
        }
    }

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
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        merge(arr1, arr2, n, m);

    }

    static void merge(int[] arr1, int[] arr2, int n, int m) {
        int gap = (int) Math.ceil((double)(m+n)/2);
        int previous = m + n;
        int i = 0;
        int j = i + gap;
        while (gap != previous) {
            i=0;
            j=i+gap;
            while (j != (m + n)) {
                System.out.println(i+" "+j);
                if (i >= n && j >= n) {                   
                    if (arr2[i-n] > arr2[j-n]) {
                        arr2[j-n] = arr2[i-n] + arr2[j-n] - (arr2[i-n] = arr2[j-n]);
                    }
                    i++;
                    j++;
                }
                if (i < n && j >= n) {
                    if (arr1[i] > arr2[j-n]) {
                        arr2[j-n] = arr1[i] + arr2[j-n] - (arr1[i] = arr2[j-n]);
                    }
                    i++;
                    j++;
                }
                if (i < n && j < n) {
                    if (arr1[i] > arr1[j]) {
                        arr1[j] = arr1[i] + arr1[j] - (arr1[i] = arr1[j]);
                        
                    }
                    i++;
                    j++;
                }


            }
            previous = gap;
            gap = (int)Math.ceil((double)gap/2);
        }
    }
}
