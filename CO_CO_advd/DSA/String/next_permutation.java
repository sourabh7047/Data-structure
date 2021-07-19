package DSA.String;

import java.util.*;
import java.lang.*;

import java.io.*;

public class next_permutation {
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
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i : nextPermutation(n, arr)){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static List<Integer> nextPermutation(int N, int arr[]) {
        // code here
        int p=N-1, bp=N-1;
        boolean checker = false;
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=N-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                if(i==0) checker =! checker;
                p = bp = i;
            } else if(arr[i] == arr[i+1]){
                p = bp = i;
            } else{
                bp = i;
                break;
            }
        }
        // System.out.println(p +" : "+ bp);

        if(checker){
            for(int i=0; i<N; i++){
                arr2.add(arr[i]);
            }
            return arr2;
        }
        
        // special case
        for(int i=p; i<N;i++){
            if(arr[i]<arr[p] && arr[i]>arr[bp]){
                p = i;
            }
        }
        // System.out.println(p +" : "+ bp);
        // exchange
        int temp = arr[p];
        arr[p] = arr[bp];
        arr[bp] = temp;

        
        partSort(arr, N, ++bp, arr.length-1);

        for(int i=0; i<N; i++){
            arr2.add(arr[i]);
        }

        return arr2;

        
    }


	static void partSort(int[] arr, int N, int a, int b)
	{
		// Variables to store start and end of the index range
		int l = Math.min(a, b);
		int r = Math.max(a, b);

		// Temporary array
		int[] temp = new int[r - l + 1];
		int j = 0;
		for (int i = l; i <= r; i++) {
			temp[j] = arr[i];
			j++;
		}

		// Sort the temporary array
		Arrays.sort(temp);

		// Modifying original array with temporary array elements
		j = 0;
		for (int i = l; i <= r; i++) {
			arr[i] = temp[j];
			j++;
		}
	}
}
