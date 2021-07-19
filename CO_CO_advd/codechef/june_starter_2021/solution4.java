package codechef.june_starter_2021;

import java.util.*;
import java.lang.*;
import java.io.*;

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

    static class Hash {
        int N;
        int mod;
        final int base = 33;

        public Hash() {
            this.N = 1000006;
            this.mod = 1000000009;
        }

        public Hash(int N, int mod) {
            this.N = N;
            this.mod = mod;
        }

        int add(int a, int b, int mod) {
            int res = (a + b) % mod;
            if (res < 0) {
                res += mod;
            }
            return res;
        }

        int mult(int a, int b, int mod) {
            int res = (int) ((a * (long) 1 * b) % mod);
            if (res < 0) {
                res += mod;
            }
            return res;
        }

        int power(int a, int b, int mod) {
            int res = 1;
            a = a % mod;
            if (a == 0) {
                return 0;
            } else {
                while (b > 0) {
                    if (b % 2 == 1) {
                        res = mult(res, a, mod);
                    }
                    a = mult(a, a, mod);
                    b /= 2;
                }
            }
            return res;
        }

        int[] pw = new int[N];
        int[] inv = new int[N];
        int[] hash = new int[N];

        void precalc() {
            pw[0] = 1;
            for (int i = 1; i < N; i++) {
                pw[i] = mult(pw[i - 1], base, mod);
            }

            int pw_inv = power(base, mod - 2, mod);
            // int pw_inv = (int)Math.pow(base, mod-2)%mod;
            inv[0] = 1;
            for (int i = 1; i < N; i++) {
                inv[i] = mult(inv[i - 1], pw_inv, mod);

            }

        }

        void build(String s) {
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                hash[i] = add((i == 0) ? 0 : hash[i - 1], mult(pw[i], s.charAt(i) - 'a' + 1, mod), mod);
            }
        }

        int getHash(int x, int y) {
            int res = add(hash[y], (x == 0) ? 0 : -hash[x - 1], mod);
            res = mult(res, inv[x], mod);
            return res;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        long t = sc.nextInt();
        while (t-- > 0) {

            long l = sc.nextLong();
            long h = sc.nextLong();
            String s = sc.next();
            long count = 0; 

            // String[] nums = s.split("1");

            // for (int i = 0; i < nums.length; i++) {
            //     long x = nums[i].length();
            //     if (x > 0) {
            //         System.out.println(nums[i]);
            //         h = 2 * (h - x);
            //     }
            // }

            for(int i=0; i<s.length(); i++){
            if(s.charAt(i)== '1' && count>0){
            h= 2*(h-count);
            count =0;
            } else if(s.charAt(i) == '0') {
            count++;
            }
            }
            if(count>0){
            h= 2*(h-count);

            }

            if (h <= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
