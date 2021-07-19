package DSA.MATRIX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class search_a_2D_matrix {
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

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();

        System.out.println(searchMatrix(matrix, target));
    }

    // public static boolean bs(int[][] matrix, int target,int r, int rs, int re) {

    //     while(rs <= re) {
    //         int middle = (rs + re) / 2;
    //         if (target == matrix[rs][middle]) {
    //             return true;
    //         } else if (target > matrix[r][middle]) {
    //             rs = middle+1;
    //         } else if (target < matrix[r][middle]) {   
    //             re = middle-1;
    //         }
    //     }
    //     return false;
    // }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int c = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (target < matrix[i][c-1]) {
                int index =  Arrays.binarySearch(matrix[i], target);
                if(i>=0){
                    return true;
                }
            } else if (target == matrix[i][c-1]) {
                return true;
            }
        }
        return false;
    }
}
