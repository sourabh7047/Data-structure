package DSA.MATRIX;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Random;
import java.util.Set;

public class solution4 {
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
            int k = sc.nextInt();
            int f = sc.nextInt();
            int p = -1;

            ArrayList<Integer> is = new ArrayList<>();
            ArrayList<Integer> ie = new ArrayList<>();
            

            // for the starting time at 0;
            ie.add(0);
            for (int i = 0; i < 2 * n; i++) {
                if (p == -1) {
                    is.add(sc.nextInt());
                    p = p * -1;
                } else if (p == 1) {
                    ie.add(sc.nextInt());
                    p = p * -1;
                }
            }
            // to end the starting row with the ending time;
            is.add(f);

            
            int total =0;
            for (int i = 0; i < n + 1; i++) {
                if(is.get(i)>ie.get(i)){

                    total = total + is.get(i) - ie.get(i);
                }
            }

            if (total>=k) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}


// for (int x : is) {
//     System.out.print(x + " ");
// }
// System.out.println();

// for (int x : ie) {
//     System.out.print(x + " ");
// }
// System.out.println();