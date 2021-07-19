package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


import java.util.Random;

public class elements_more_than_NbyK {
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

        ArrayList<Integer> result = ratioJustified(arr, n, k);
        for (Integer x : result)
            System.out.println(x);

    }

    static ArrayList<Integer> multipleAppearance(int[] arr, int n, int k) {
        Arrays.sort(arr);
        Map<Integer, Integer> multiple = new HashMap<Integer, Integer>();
        ArrayList<Integer> output = new ArrayList<>();

        Integer ratio = n / k;

        for (int x : arr) {
            if (multiple.containsKey(x)) {
                int value = multiple.get(x);
                value += 1;
                multiple.put(x, value);
            } else {
                multiple.put(x, 1);
            }
        }

        for (Map.Entry unique : multiple.entrySet()) {
            int value = (int) unique.getValue();
            if (value > ratio) {
                output.add((int) unique.getKey());
            }
        }

        return output;
    }

    static ArrayList<Integer> ratioJustified(int[] arr, int n, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> output = new ArrayList<>();

        int count = 0;
        int i = 0;
        int ratio = n / k;
        while (i < n) {
            
            if (i == 0) {
                count = 1;
            } else if (arr[i] == arr[i - 1]) {
                count += 1;
            } else {
                if (count >= ratio) {
                    output.add(arr[i - 1]);
                    count = 1;
                } else {
                    count = 1;
                }
            }
            i++;
        }

        if (count >= ratio) {
            output.add(arr[n - 1]);
        } 

        return output;

    }
}
