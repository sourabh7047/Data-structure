package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Set;

public class alternate_positive_negative {
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
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] output = alternate2(arr, n);
        for (int x : output) {
            System.out.print(x + " ");
        }
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
        return rs;

    }

    static void replace(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j] - (arr[j] = arr[i]);
    }

    // complex approach without using extra space
    static int[] alternate2(int[] arr, int n) {
        // first sort the array
        Arrays.sort(arr);

        // binary search the position of first appearance of the positive element
        int pos = bs(arr, 0, 0, arr.length - 1);
        // System.out.println(pos);

        // peek whether the element is out of the array meaning there is no poitive integer
        int pal = arr.length-pos;
        // System.out.println(pal);

        // if no positive integer than return the array as it is
        if (pal <0) {
            return arr;
        
        }
        // else now interate through the array and alternative place the positive and negative integer 
         else {

            // switcher is used to switch for placing negative and positive integer
            int switcher = -1;

            // first index of the subarrays having negative and positive elements  
            int i = 0, j = pos;

            //  if the 2 indexes meet with each other meaning all the negative numbers are placed within the positive integers
            // if the index of the positive array moving out of the array meaning no more positive integer to place
            while (i != j && j < arr.length) {

                // switchers are active
                if (switcher == -1) {
                    // position negative than move the negative index
                    if (arr[i] < 0) {
                        i++;
                    } 
                    // else replace with the positive integer
                    // since j index is going linearly over the positive subarray, every time replacement occurs 
                    // positive number is replaced with the negative integer meaning we are creating linear stock of the 
                    // negative number in from of the j index ready to replaced with the positive integer by the index i 
                    //at alternate position till the time the 2 indexes meet with each other or index j goes out of range
                    else {
                        replace(arr, i, j);
                        i++;
                        j++;
                    }
                    switcher *= -1;
                } else if (switcher == 1) {
                    if (arr[i] >= 0) {
                        i++;
                    } else {
                        replace(arr, i, j);
                        System.out.println("yes");
                        i++;
                        j++;
                    }
                    switcher *= -1;
                }
            }
        }
        return arr;
    }

    // naive approach using extra space
    static int[] alternate(int[] arr, int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                positive.add(arr[i]);
            else
                negative.add(arr[i]);
        }
        int i = 0, j = 0, k = 0, Switcher = 1;
        while (i < positive.size() && j < negative.size()) {
            if (Switcher == 1) {
                arr[k++] = positive.get(i++);
                Switcher *= -1;
            } else if (Switcher == -1) {
                arr[k++] = negative.get(j++);
                Switcher *= -1;
            }
        }

        if (i < positive.size()) {
            while (i < positive.size()) {
                arr[k++] = positive.get(i++);
            }
        } else if (j < negative.size()) {
            while (j < negative.size()) {
                arr[k++] = negative.get(i++);
            }
        }

        return arr;
    }
}
