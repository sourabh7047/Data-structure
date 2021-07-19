package DSA.String;

import java.util.*;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Add;

import java.io.*;

public class count_palindromic_subsequence {
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
            String str = sc.next();

            System.out.println(countPS(str));
        }
    }

    static long add(long a, long b, long c){
        int mod = (int)(1e9+7);
        long res = (a+b+c)%mod;
        if(res<0){
            res += mod;
        }
        return res;
    }
   

    static long countPS(String str)
    {
        // Your code here
        int mod = (int)(1e9+7);

        long[][] dp = new long[str.length()][str.length()];

        for(int gap=0; gap<str.length(); gap++){
            for(int i=0, j=gap; j<str.length(); i++, j++){
                if(gap==0){
                    dp[i][j] = 1;
                } else if(gap==1){
                    dp[i][j] = str.charAt(i) == str.charAt(j)? 3:2;
                } else {
                    if(str.charAt(i) == str.charAt(j)){
                        System.out.println(i+ " "+ j);
                        dp[i][j] = add(dp[i+1][j],dp[i][j-1],1);
                    } else {
                        dp[i][j] = add(dp[i+1][j] ,dp[i][j-1], -dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }

}
