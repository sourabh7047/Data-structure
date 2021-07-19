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

public class rotate_ninety_degree {
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
        int n= sc.nextInt();

        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j]  = sc.nextInt();
            }
        }
         
        for(int[] x : rotate(matrix)){
            for(int y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }

    }
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int save;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                save  = matrix[i][j]; 
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = save;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<(n+1)/2; j++){
                save = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = save;
            }
        }
        return matrix;
    }
}
