package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class word_wrap {
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
            int n = sc.nextInt();
            int length = sc.nextInt();

            int[] ws = new int[length];

            for(int i =0; i<length; i++){
                ws[i] = sc.nextInt();
            }

            System.out.println(solveWordWrap(ws, n));
        }
        

        
    }

    public static int solveWordWrap (int[] nums, int k)
        {
            // Code here
            Stack<Integer> wrap = new Stack<>();
            // forward and backward min
            int fm = 0;
            int bm = 0;
            
            for(int i=0; i<nums.length; i++){
                if(i==0){
                    wrap.push(nums[i]);
                }else {

                    if(wrap.peek()+nums[i]+1<=k){
                        wrap.push(wrap.pop()+nums[i]+1);
                    } else {
                        fm +=Math.pow(k - wrap.peek(),2) ;
                        wrap.push(nums[i]);
                    }
                }
            }
            // while( wrap.size()>0){
            //     System.out.print(wrap.pop()+" ");
            // }
            // System.out.println();
            wrap.clear();

            for(int i=nums.length-1; i>=0; i--){
                // System.out.println(i+"top");
                if(i==nums.length-1){
                    wrap.push(nums[i]);
                }else {

                    if(wrap.peek()+nums[i]+1<=k){
                        // System.out.println(wrap.peek()+" "+nums[i]+ " "+1) ;
                        wrap.push(wrap.pop()+nums[i]+1);
                    } else {
                        if(wrap.size() != 1){
                            bm +=Math.pow(k - wrap.peek(),2) ;
                        }
                        // System.out.println(bm);
                        wrap.push(nums[i]);
                    }
                }
            }
            bm +=Math.pow(k - wrap.peek(),2) ;

            // while(wrap.size()>0){
            //     System.out.print(wrap.pop()+" ");
            // }
            // System.out.println();
            wrap.clear();
            
            System.out.println(fm+ " " + bm);

            return Math.min(fm, bm);
        }
}