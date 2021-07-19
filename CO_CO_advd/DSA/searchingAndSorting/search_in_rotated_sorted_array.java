package DSA.searchingAndSorting;

import java.util.*;
import java.io.*;

public class search_in_rotated_sorted_array {
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
    // this bs is used to search the pivot if the array is rotated
    static int rotatedbs(int[] arr, int start, int end) {
        int np = -1;
        int middle = (start + end) / 2;
        if (start <= end) {
            if (arr[middle] > arr[middle + 1]) {
                return middle;
            } else {
                
                int np1 = rotatedbs(arr, start, middle - 1);
                int np2 = rotatedbs(arr, middle + 1, end);
                np = Math.max(np1, np2);
            }
        }
        return np;
    }

    public static int bs(int[] roots, int target, int rs, int re) {

        while (rs <= re) {
            int middle = (rs + re) / 2;
            if (target == roots[(int) middle]) {
                return (int) middle;
            } else if (target > roots[(int) middle]) {
                rs = middle + 1;
            } else if (target < roots[(int) middle]) {
                re = middle - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = {4,5,6,7,0,1,2};
        int target = 2;

        int x = search(arr, target);
        System.out.println(x);
    }

    public static int search(int[] nums, int target) {
        int pivot = rotatedbs(nums, 0, nums.length-2);
        
        int left =  bs(nums, target, 0, pivot);
        int right = bs(nums, target, pivot+1, nums.length-1);

        int res = Math.max(left, right);

        return res;
    }
}
