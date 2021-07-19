package DSA.MATRIX;

//  the max_area of the rectangle that can be formed in the given matrix, this question is the extension of histogram max_area
// and smaller integer towards right or left, so for this question we make a array containing elements of the 1 row of the matrix
// for each row we will found the max area possilble throught concept of the max_area histogram by finding the smallest integer
// towards left and right, we will store this area into an integer know we will find the max area for both the array by making 
// towers of the histogram in the form of the array and find the area for this loop now we will compare the area of the 2 loops 
// and give the highest area possible, these steps are followed every time by forming histogram tower evertime.  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Stack;

public class max_rectangle {
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
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] M = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxArea(M, m, n));

    }

    public static int histogram_max_area(int[] histo) {
        int n = histo.length;
        int max_area = 0;
        int width, area;

        int[] sl = new int[n];
        int[] sr = new int[n];

        // code smallest element towards the left;
        Stack<Integer> st = new Stack<>();
        sr[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && histo[st.peek()] >= histo[i]) {
                st.pop();
            }

            if (st.size() == 0) {
                sr[i] = n;
            } else {
                sr[i] = st.peek();
            }

            st.push(i);
        }

        // for getting smaller element to the left;
        st.clear();
        sl[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && histo[i] <= histo[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                sl[i] = -1;
            } else {
                sl[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            width = sr[i] - sl[i] - 1;
            area = width * histo[i];
            if (area > max_area) {
                max_area = area;
            }
        }

        return max_area;
    }

    public static int maxArea(int M[][], int m, int n) {
        // add code here.
        int max_area = 0;
        int area;

        int[] histo = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (histo[j] > 0 && M[i][j] == 1) {
                    histo[j] = histo[j] + M[i][j];
                } else {
                    histo[j] = M[i][j];
                }
            }
            area = histogram_max_area(histo);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
}
