package DSA.MATRIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;


public class row_with_max_1 {
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

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(rowWithMax1s(arr, n, m));
    }
    public static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int rs, re, mid, once, row=-1, maxOnce = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            rs = 0; 
            re = arr[i].length-1;

            while(rs<=re){
                mid = (rs+re)/2;
                if(arr[i][mid] == 1){
                    re = mid-1;
                } else rs = mid+1;
            }

            once = m - rs;
            if(once>maxOnce){
                maxOnce = once;
                row = i;
            }
            
        }
        return row;
    }
}
