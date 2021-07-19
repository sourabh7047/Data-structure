package DSA.Codeforces;

import java.util.*;
import java.lang.*;
import java.io.*;

public class solution1 {
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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            if (n % 2 == 0) {
                
                int switcher = -1;
                for (int i = 0; i < n; i++) {
                    if(switcher == -1){
                        arr[i] = i+2;
                        switcher *= -1;
                    } else if(switcher == 1){
                        arr[i] = i;
                        switcher *= -1;
                    }
                }

            } else if(n%2==1){
                int set = n-3;
                int switcher = -1;
                for (int i = 0; i < set; i++) {
                    if(switcher == -1){
                        arr[i] = i+2;
                        switcher *= -1;
                    } else if(switcher == 1){
                        arr[i] = i;
                        switcher *=-1;
                    }
                }

                arr[set] = set+3;
                arr[set+1] = set+1;
                arr[set+2] = set+2;


            }

            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}