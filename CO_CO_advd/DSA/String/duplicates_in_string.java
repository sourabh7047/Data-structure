package DSA.String;

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

import javax.print.DocFlavor.STRING;

import java.util.Random;
import java.util.Stack;

public class duplicates_in_string {
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
        
        String S = sc.next();

        HashMap<Character, Integer> duplicates = new HashMap<>();

        for(int i=0; i<S.length(); i++){
            if(!duplicates.containsKey(S.charAt(i))){
                duplicates.put(S.charAt(i), 1);
            } else {
                duplicates.put(S.charAt(i), duplicates.get(S.charAt(i))+1);
            }
        }

        for(Map.Entry<Character, Integer> entry : duplicates.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey());
            }
        }
}
}
