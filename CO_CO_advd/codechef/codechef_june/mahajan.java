package DSA.codechef_june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class mahajan {
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

        public static void main(String[] args) {
            FastReader sc = new FastReader();
            int n = sc.nextInt();

            Pair[] number = new Pair[n];
            for(int i=0; i<n; i++){
                number[i].station = sc.nextInt();
                number[i].destination = i;
            }

            for(Pair x : number){
                System.out.println(x.station + " + " +x.destination);
            }

        }

        public static class Pair{
            int station;
            int destination;

            public Pair(int station, int destination){
                this.destination = destination;
                this.station = station;
            }
        }
    }

}