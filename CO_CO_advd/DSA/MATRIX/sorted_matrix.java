package DSA.MATRIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class sorted_matrix {
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
        int  N = sc.nextInt();
        
        int[][] Mat = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Mat[i][j] = sc.nextInt();
            }
        }

        int[][] result = sortedMatrix(N, Mat);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(result[i][j]+ " "); 
            }
            System.out.println();
        }


    }

    public static int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        int[] elements = new int[N*N];
        
        int k=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                elements[k++] = Mat[i][j];
            }
        }
     
        Arrays.sort(elements);
       
        k=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Mat[i][j] = elements[k++];
            }
        }

        return Mat;
    }
}
