package DSA.Graph;

import java.util.*;
import java.io.*;

public class flood_fill {
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
        FastReader sn= new FastReader();
        int m = sn.nextInt();
        int n = sn.nextInt();


        int sr = sn.nextInt();
        int sc = sn.nextInt();
        int newColor = sn.nextInt();
        
        int[][] image = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                image[i][j] = sn.nextInt();
            }
        }
        System.out.println();

        int[][] variable = floodFill(image, sr, sc, newColor);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(variable[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void flooding(int[][] image,int m, int n, int sr, int sc, int target, int newColor){
        if(sr<0 || sc<0 || sr>=m || sc>=n) return;
        if(image[sr][sc] == newColor) return;
        else if(image[sr][sc] == target) image[sr][sc] = newColor;
        else return;

        flooding(image, m, n, sr+1, sc,target, newColor);
        flooding(image, m, n, sr, sc+1,target, newColor);
        flooding(image, m, n, sr, sc-1,target, newColor);
        flooding(image, m, n, sr-1, sc,target, newColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int m = image.length;
        int n = image[0].length;
        int target = image[sr][sc];
        flooding(image, m, n, sr, sc, target, newColor);
        return image;
    }
}
