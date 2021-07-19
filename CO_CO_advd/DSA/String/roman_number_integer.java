package DSA.String;

import java.util.*;
import java.io.*;

public class roman_number_integer {
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
        
    }

    public static int Roman_To_Int(String roman){
        int value =0;

        HashMap<Character, Integer> romanval = new HashMap<>();
        romanval.put('I', 1);
        romanval.put('V', 5);
        romanval.put('X', 10);
        romanval.put('L', 50);
        romanval.put('C', 100);
        romanval.put('D', 500);
        romanval.put('M', 1000);

        char[] charroman = roman.toCharArray();

        if(charroman.length == 0){
            return 0;
        } 

        if(charroman.length == 1){
            return romanval.get(charroman[0]);
        }

        value += romanval.get(charroman[0]);
        for(int i=1; i<charroman.length; i++){
            if(romanval.get(charroman[i]) - romanval.get(charroman[i-1]) > 0){
                value+= romanval.get(charroman[i]) - 2*romanval.get(charroman[i-1]);
            } else {
                value+= romanval.get(charroman[i]);
            }
        }
        return value;
    }
}
