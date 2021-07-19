package DSA.Codeforces;

import java.util.*;
import java.lang.*;
import java.io.*;

public class solution2 {
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
        while (t-- > 0) {
            long n = sc.nextInt();
            long ll = 3;
            long ul = 2*n-1;
            
            long count=0;

            long[] arr = new long[(int)n];

            for(int i=0;i <n; i++){
                arr[i] = sc.nextInt();               
            }

            Arrays.sort(arr);
            long pos = bs(arr, ul, 0, n-1);
            System.out.println(pos);

           for(int i=0; i<pos-1; i++){
               for(int j=i+1; j<pos; j++){
                    if(arr[i]*arr[j]<= ul && arr[i]*arr[j]>= ll){
                        count++;
                    }
               }
           }

           System.out.println(count);


           
            
        }
    }
}
