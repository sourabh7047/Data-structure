package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class parenthesis_checker {
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

    public static long bs(long[] roots, long target, long rs, long re) {

        while (rs <= re) {
            long middle = (rs + re) / 2;
            if (target == roots[(int) middle]) {
                return (int) middle;
            } else if (target > roots[(int) middle]) {
                rs = middle + 1;
            } else if (target < roots[(int) middle]) {
                re = middle - 1;
            }
        }
        return rs;

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            String x= sc.next();
            System.out.println(ispar(x));
        }
    }

    static boolean ispar(String x)
    {
        // add your code here

        Stack<Integer> checker = new Stack<>();
        checker.add( (int)x.charAt(0));

        for(int i=1; i<x.length(); i++){

            if(checker.size()>0){
                if((int)x.charAt(i) == (int)checker.peek()+1 || (int)x.charAt(i) == (int)checker.peek()+2){
                    checker.pop();
                } else {
                    checker.add((int)x.charAt(i));
                }

            } else{
                checker.add((int)x.charAt(i));
            }
        }
        if(checker.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}
