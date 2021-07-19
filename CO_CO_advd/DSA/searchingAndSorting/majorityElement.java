package DSA.searchingAndSorting;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.*;

public class majorityElement {
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
        
    }

    static int majorityElements(int a[], int size){
        // your code here
        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0; i<size; i++){
            if(count.containsKey(a[i])){
                count.put(a[i], 1+ count.get(a[i]));
            } else {
                count.put(a[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(entry.getValue()>(size/2)){
                return (int)entry.getKey();
            }
        }

        return -1;
    }
}
