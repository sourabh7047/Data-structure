package DSA.Graph;

import java.util.*;

import DSA.String.string_in_a_grid;

import java.io.*;

public class rat_in_a_maze1 {
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

        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        
        for (String x : findPath(m, n)) {
            System.out.println(x);
        }

    }

    public static void destination(int[][] m, int i, int j, String sti, int[][] visited) {
        if(i<0 || j<0 || j>=m.length || i>=m.length) return;
        if(m[i][j] == 0 || visited[i][j] == 1) return;
        if(i== m.length-1 && j == m.length-1){
            res.add(sti);
            return;
        }else {
            visited[i][j] = 1;
        }

        destination(m, i+1, j, sti+"D", visited);
        destination(m, i-1, j, sti+"U", visited);
        destination(m, i, j-1, sti+"L", visited);  
        destination(m, i, j+1, sti+"R", visited);
        
        visited[i][j] = 0;

    }

    static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] visited = new int[n][n];
        String sti = "";
        destination(m, 0, 0, sti, visited);

        return res;
    }
}