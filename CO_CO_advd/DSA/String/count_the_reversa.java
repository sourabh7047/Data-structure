package DSA.String;

// it is better to take difference and of ascii values and comparing it with the result rather than equating them by ==. 

import java.util.*;
import java.io.*;

public class count_the_reversa {
    
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
        FastReader sc= new FastReader();
        String s = sc.next();

        System.out.println(reverse_num(s)); 
    }
    static int reverse_num(String s) {

        if(s.length()%2 !=0){
            return -1;
        }

        int reversal = 0;
        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (bucket.size() == 0) {
                bucket.add((int)s.charAt(i));
            } else {
                if (((int)s.charAt(i)-bucket.peek() == 2)) {
                    bucket.pop(); 
                } else {
                    bucket.add((int)s.charAt(i));
                }
            }
        }

        if (bucket.size() != 0) {
            while (bucket.size() != 0) {
                if (bucket.pop() - bucket.peek() == -2) {
                    bucket.pop();
                    reversal += 2;
                } else {
                    bucket.pop();
                    reversal += 1;
                }

            }
        }

        return reversal;

    }
}