package DSA.MATRIX;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;

public class spirally_traversing_a_matrix {
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
        FastReader sc =new FastReader();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        for(int i=0;i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int x : spirallyTraverse(matrix, r, c)){
            System.out.print(x+" ");
        }
        
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        ArrayList<Integer> st = new ArrayList<>();
        
       int  rm = 0;         //row minor
       int rM = r-1;        //row major
       int cm =0;           // column minor
       int cM = c-1;        // column major
       int te = 0;          //total

       while(te<r*c){
           

           for(int i=cm; i<=cM; i++){
               te +=1;
               if(te<=r*c){
                   int num = matrix[rm][i];
                   st.add(num);
               } else break;
               
           }

           for(int i=rm+1; i<=rM; i++){
            te +=1;
            if(te<=r*c){
            int num = matrix[i][cM];   
            st.add(num);
            } else break;
            
           }

           for(int i=cM-1; i>=cm; i--){
                te +=1;
                if(te<=r*c){
                int num = matrix[rM][i];
                st.add(num);
                } else break;
           }

           for(int i=rM-1; i>=rm+1; i--){
                te +=1;
                if(te<=r*c){
                int num = matrix[i][cm]; 
                st.add(num);
                } else break;
            }
            rm= rm+1;
            rM = rM-1;
            cm = cm+1;
            cM = cM-1;

            
       }

       return st;
    }
}
