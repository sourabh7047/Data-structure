package DSA.codechef_june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Random;
import java.util.Stack;

public class minimum_dual_area {
    

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

    static class Pair implements Comparable<Pair> {
        public long x;
        public long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) this.y - (int) o.y;
        }

        // getting x;
        public double getX() {
            return x;
        }

        // compareto for x;
        static class CompareX implements Comparator<Pair> {
            @Override
            public int compare(Pair m1, Pair m2) {
                return (int) m1.getX() - (int) m2.getX();
            }
        }

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a, b;

            Pair[] coordinate = new Pair[n];

            for (int i = 0; i < n; i++) {
                a = sc.nextLong();
                b = sc.nextLong();
                coordinate[i] = new Pair(a, b);

            }

            Arrays.sort(coordinate);
            long minarea1 = MinArea(coordinate, n);

            Arrays.sort(coordinate, new Pair.CompareX());
            long minarea2 = MinArea(coordinate, n);
           

            minarea1 = Math.min(minarea1, minarea2);
            System.out.println(minarea1);

        }

    }

    public static long MinArea(Pair[] coordinate, int n) {

        long[] forward = new long[n];
        long[] backward = new long[n];

        long[] minmaxXY = { coordinate[0].x, coordinate[0].x, coordinate[0].y, coordinate[0].y };
        long area, minarea = Integer.MAX_VALUE;

        // forward loop
        for (int i = 0; i < n; i++) {
            // min and max x
            if (coordinate[i].x > minmaxXY[1]) {
                minmaxXY[1] = coordinate[i].x;
            } else if (coordinate[i].x < minmaxXY[0]) {
                minmaxXY[0] = coordinate[i].x;
            }

            // min and max y
            if (coordinate[i].y > minmaxXY[3]) {
                minmaxXY[3] = coordinate[i].y;
            } else if (coordinate[i].y < minmaxXY[2]) {
                minmaxXY[2] = coordinate[i].y;
            }

            area = Math.abs(minmaxXY[3] - minmaxXY[2]) * Math.abs(minmaxXY[1] - minmaxXY[0]);
            forward[i] = area;
        }

        // reverse loop
        minmaxXY[0] = minmaxXY[1] = coordinate[n - 1].x;
        minmaxXY[2] = minmaxXY[3] = coordinate[n - 1].y;
        for (int i = n - 1; i >= 0; i--) {
            // min and max x

            if (coordinate[i].x > minmaxXY[1]) {
                minmaxXY[1] = coordinate[i].x;
            } else if (coordinate[i].x < minmaxXY[0]) {
                minmaxXY[0] = coordinate[i].x;
            }

            // min and max y
            if (coordinate[i].y > minmaxXY[3]) {
                minmaxXY[3] = coordinate[i].y;
            } else if (coordinate[i].y < minmaxXY[2]) {
                minmaxXY[2] = coordinate[i].y;
            }

            area = Math.abs(minmaxXY[3] - minmaxXY[2]) * Math.abs(minmaxXY[1] - minmaxXY[0]);
            backward[i] = area;
        }

        long sum = 0;
        for (int i = 1; i < forward.length - 2; i++) {
            sum = forward[i] + backward[i + 1];
            if (sum < minarea)
                minarea = sum;
        }

        return minarea;

    }

}