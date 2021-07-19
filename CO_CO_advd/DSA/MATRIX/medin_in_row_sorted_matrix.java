package DSA.MATRIX;

// tho jab bhi monotonous function dikhe hum binary search lga sakte ha or binary search mai hamesa row start hi answer deta hai
// jaisa ki ess question mai jab hame count kerna ka kitne value har row mai ha ho ki seconds function ke mid mai aaue value se
// choti ha tab humne binary search ke through wo value nikali ho exact mid se bdi ho or usse add kerte gye, second function public static void main(String[] args) {
// hum pta nhi hota ki kya mid hoga tab hum sirf seach space reduce kerte chale jaate hai or dekhta ki required value se kitne
// value se jo choosen number ke pehle aayengi
 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Random;


public class medin_in_row_sorted_matrix {
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
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();

            }
        }

        System.out.println(median(matrix, r, c));

    }

    public static int midlow_counter(int matrix[][], int r, int c, int compare){
        int count =0; int rs; int re;int mid;
        for(int i=0; i<r; i++){

            rs = 0;
            re = matrix[i].length-1;

            while(rs<=re){
                mid = Math.abs((rs +re)/2);
                // System.out.println("row"+ i+"mid"+ matrix[i][mid]);
                if(matrix[i][mid] <= compare) rs = mid+1;
                else re = mid-1;
                
            }
            count += rs;
        }
        // System.out.println(count);
        return count;
    }

    public static int median(int matrix[][], int r, int c) {
        // finding minimum and maximum value in the row wise sorted matrix;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for(int i=0; i<r; i++){
            if(min> matrix[i][0]) min = matrix[i][0];
            if(max<matrix[i][c-1]) max = matrix[i][c-1];
            
        }
        int mid; 
        
        // required is the position of the middle element in the sorted array of matrix element
        int count; int required =Math.abs(((r*c)+1)/2);
        // System.out.println("required: "+ required);


        while(min<=max){
            // finding the middle value from the miniturized sample size
            mid = Math.abs((min+max)/2);
            // System.out.println("mid"+ mid+"/");

            // countig the mumber of element  smaller than the middle element including the middle element
            count = midlow_counter(matrix, r, c, mid);

            // count is greater than the required or if it is equal to required
            // may be the sequence is not what we think suppose 1+9/2 mid = 5
            // but answer need not to be 12235 it can be 12222 or 12222 so high = mid -1; 
            if(count>= required) max = mid-1;

            // else if it is smaller than the size than of course we need to increase the number in range
            else min =min+1;
            
        }

        int median = min;
        return median;
    }
}
