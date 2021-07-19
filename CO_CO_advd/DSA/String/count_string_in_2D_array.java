package DSA.String;

import java.util.*;
import java.io.*;

public class count_string_in_2D_array {

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
        while(t-->0){
            
            int n = sc.nextInt();
            
            Character[][] sg = new Character[n][n];   //search_character
            
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sg[i][j] = sc.nextChar();
                }
            }
            
            String str = sc.next();
            System.out.println(stringCount(sg, str));
        }


    }

    public static int stringCount(Character[][] sg, String str){
        int n = sg.length;
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(sg[i][j] == str.charAt(0)){
                        count += nextCharac(sg, i, j, str, 1);
                }
            }
        }

        return count;
    }

    static int nextCharac( Character[][] sg, int i, int j, String str, int index ){
        int count = 0;

        if(index == str.length()){
            return 1;
        }

        if(index < str.length()){
            
            if(i-1>=0 && sg[i-1][j]== str.charAt(index) ){
                count += nextCharac(sg, i-1, j, str, index+1);     //ever write index+1 never write index++ or ++index if not necessary
            }
            if(i+1<sg.length && (sg[i+1][j]== str.charAt(index))){
                count += nextCharac(sg, i+1, j, str, index+1);      //ever write index+1 never write index++ or ++index if not necessary
            }
            if((j-1)>=0 && sg[i][j-1]== str.charAt(index)){
                count += nextCharac(sg, i, j-1, str, index+1);      //ever write index+1 never write index++ or ++index if not necessary
            }
            if((j+1)<sg.length && sg[i][j+1]  == str.charAt(index)){
                count += nextCharac(sg, i, j+1, str, index+1);      //ever write index+1 never write index++ or ++index if not necessary
            }  
        }
        
        return count;
    }
}
