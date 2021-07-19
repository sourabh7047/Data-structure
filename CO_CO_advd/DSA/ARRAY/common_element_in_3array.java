package DSA.ARRAY;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Set;

public class common_element_in_3array {

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
        
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] A = new int[n1];
        int[] B = new int[n2];
        int[] C = new int[n3];

        for(int i=0; i<n1; i++){
            A[i]= sc.nextInt();
        }

        for(int i=0; i<n2; i++){
            B[i]= sc.nextInt();
        }

        for(int i=0; i<n3; i++){
            C[i]= sc.nextInt();
        }

        ArrayList<Integer> output = commonelement(A, B, C, n1, n2, n3);
        for(int x=0; x<output.size(); x++){
            System.out.println(output.get(x)+" ");
        }

    }
    static ArrayList<Integer> commonelement(int[] A, int[] B, int[] C, int n1,int  n2, int n3){
        ArrayList<Integer> commonele = new ArrayList<>();
        int i=0,  j=0, k=0;

        while(i < A.length && j < B.length && k < C.length){

            if(A[i] == B[j] && B[j] == C[k]){
                commonele.add(A[i]);
                
            } 
            
            if(A[i]<B[j]){
                i++;
            } else if(B[j] < C[k]){
                j++;
            } else {
                k++;
            }
        }

        return commonele;
            
    } 
}
