package codechef.Codechef_june_cookoff;

import java.util.*;
import java.lang.*;
import java.io.*;

public class soluion2 {
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
        long t = sc.nextLong();
        while(t-->0){
            long n = sc.nextLong();

            Set<Integer> ballons = new HashSet<>();
            
            for(int i=1; i<=7; i++){
                ballons.add(i);
            }

            int[] diff = new int[(int)n];

            for(int i=0; i<n; i++){
                diff[i] = sc.nextInt();
            }


            for(int i =0; i<n; i++){
               
                if(ballons.contains(diff[i])){
                    ballons.remove(diff[i]);
                }

                if(ballons.size() == 0){
                    System.out.println(i+1);
                    break;
                }
            }

            ballons.clear();
        }
    }
}
