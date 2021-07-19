package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class merge_without_extra_space17 {

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

        result rs = new result();
        rs = merge(arr1, arr2, n, m);

        Arrays.sort(rs.array1);
        Arrays.sort(rs.array2);


        for (int x : rs.array1)
            System.out.print(x + " ");
            System.out.println();
        for (int x : rs.array2)
            System.out.print(x + " ");
        System.out.println();

    }
    
    static class result {
        int[] array1;
        int[] array2;
    }

    static result merge(int arr1[], int arr2[], int n, int m) {
        int a1s = 0, a2s = 0, a1e = n - 1, a2e = m - 1;
        boolean checker1 = true, checker2 = true;

        result rs = new result();

        while (checker1 || checker2) {
            if (a1s <= n - 1) {
                if (arr2[a2s] < arr1[a1s]) {
                    arr2[a2s] = arr2[a2s] + arr1[a1s] - (arr1[a1s] = arr2[a2s]);
                    a1s++;
                } else {
                    a1s++;
                }
            } else {
                checker1 = false;

            }
            if (a2e >= 0 && a1e>-1 ) {
                if (arr2[a2e] < arr1[a1e]) {
                    arr2[a2e] = arr2[a2e] + arr1[a1e] - (arr1[a1e] = arr2[a1e]);
                    a1e--;
                } else {
                    a2e--;
                }
            } else {
                checker2 = false;

            }
        }
        rs.array1 = arr1;
        rs.array2 = arr2;

        return rs;

    }
}