package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class hashing {
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
        int N =1000006;
        int mod=1000000009;
        final int base =33;


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
                    if (b %2 == 1) {
                        res = mult(res, a, mod);
                    }
                    a = mult(a, a, mod);
                    b /=2;
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
        Hash hashing = new Hash();
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            hashing.precalc();
            hashing.build(s);
            System.out.println(hashing.getHash(1, 2));

            // char x= 'c';
            // char u = 'c';
            // if(u == x){

            //     System.out.println("yes");
            // }
            String f = "AAAAAAAAAAAAAAAAAAA";
            System.out.println(f.length());

        }
    }
}
