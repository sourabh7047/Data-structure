package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Set;

public class longest_coinsecutive_subsequence{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
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
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findLongestConseqSubseq(arr, n));
        


    }
    static int findLongestConseqSubseq(int[] arr, int n){
        Arrays.sort(arr);

        int maxCons = 1;
        int localCons =1;
        int i= 0;
        int current = arr[0];
        while(++i<n){
            if(current+1 == arr[i]){
                
                localCons +=1;
                current +=1;
                if(localCons>maxCons){
                    maxCons = localCons;
                }
            } else if(arr[i] == arr[i-1]){
                continue;
            } 
            else {
                current = arr[i];
                localCons =1;
            }
        }
        return maxCons;

    }
}