package DSA.String;

import java.util.*;
import java.io.*;

public class rabin_karp2 {
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
        while (t-- > 0) {
            String s  = sc.next();
            String pat = sc.next();

            for(int x : pattern_search(s, pat)){
                System.out.println(x+" ");
            }
            System.out.println();

        }
    }

    public static ArrayList<Integer> pattern_search(String s, String pat) {

        ArrayList<Integer> indexes = new ArrayList<>();

       Set<String> hashpat = new HashSet<>();
        hashpat.add(pat);

       for(int i=0; i<s.length()-pat.length()+1; i++){
           if(hashpat.contains(s.substring(i, i+pat.length()))){
                indexes.add(i);
           }
       }

       return indexes;
        
    }
}
