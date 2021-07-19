package DSA.MATRIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Stack;

public class Kth_element_in_matrix {
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

        public static void main(String[] args) {
            FastReader sc = new FastReader();
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            System.out.println(kthSmallest(mat, n, k));
        }

        public static int kthSmallest(int[][] mat, int n, int k) {
            // code here.
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int mid, count;

            for(int i=0; i<n; i++){
                if(mat[i][0] <min) min = mat[i][0];
                if(mat[i][n-1] > max) max = mat[i][n-1];
            }
            // System.out.println(min+ " "+ max);

            while(min<=max){
                mid = (min + max)/2;
                // System.out.println("mid "+ mid+"/");
                count = count_below_x(mat, n, mid);
                if(count>= k){
                    max = mid-1;
                } else {
                    min = mid+1;
                }
            }

            return max;
        }

        public static int count_below_x(int[][] mat, int n, int target){
            int rs, re, middle, count=0;

            for(int i=0; i<n; i++){
                rs = 0;
                re = n-1;

                while(rs<=re){
                    middle = (rs+re)/2;
                    if(mat[i][middle] >=target){
                        re = middle-1;
                    } else{
                        rs = middle+1;
                    }
                }

                count += rs;
            }

            return count;
        }
    }
}
