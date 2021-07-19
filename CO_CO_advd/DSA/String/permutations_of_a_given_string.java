package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class permutations_of_a_given_string {
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

        String str = sc.next();
        for(String i : find_permutation(str)){
            System.out.println(i);
        } 

    }
    static ArrayList<String> permute = new ArrayList<>();

    public static List<String> find_permutation(String S) {
        // Code here
        inner_permute(S, "");
        return permute;
    }

   

    public static void inner_permute(String ques, String rsf ){

        if(ques.length() == 0){
            permute.add(rsf);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            char charac = ques.charAt(i);
            String quesl = ques.substring(0, i);
            String quesr = ques.substring(i+1);
            inner_permute(quesl+quesr, rsf+charac);
        }
         
    }
}
