package DSA.Graph;

import java.util.*;
import java.io.*;
import java.net.ConnectException;

public class making_wired_connection {
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
        FastReader sc= new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] connections = new int[n][2];

        for(int i=0; i<m; i++){
            for(int j=0; j<2; j++){
                connections[i][j] = sc.nextInt();
            }
        }

        System.out.println(makeconnected(n, connections));


    }

    public static boolean vertexA(int src){  
        connect.putIfAbsent(src, new LinkedList<>());
        return true;      
    }

    static Map<Integer, LinkedList<Integer>> connect = new HashMap<>();
    public static void unweightedg(int src, int desti){
        connect.get(src).add(desti);
        connect.get(desti).add(src);

    } 



    public static int bfs(int src, Set<Integer> visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int count =0;
        q.add(src);
        while(!q.isEmpty()){
            int ele = q.poll();
            
            if(!visited.contains(ele)){
                visited.add(ele);
                count+=1;
            }

            for(int x : connect.get(ele)){
                if(!visited.contains(x)) q.add(x);
            }

        }

        return count;

    }

    public static int makeconnected(int n, int[][] connections){

        if(connections.length<n-1){
            return -1;
        }

        int count =0;int disconnections = 0;

        for(int i=0; i<n; i++){
            vertexA(i);
        }

        for(int i=0; i<connections.length; i++){
            unweightedg(connections[i][0], connections[i][1]);
        }

        Set<Integer> visited = new HashSet<>();

        for(Integer x : connect.keySet()){
            if(!visited.contains(x)){
                count += bfs(x, visited);
                if(count<n){
                    disconnections += 1;
                }
            }
        }

        return disconnections;
    }
}
