package DSA.Graph;

import java.util.*;
import java.io.*;

public class detect_cycle_in_undirected_graph {
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
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < 2; j++) { 
                adj.get(i).add(sc.nextInt());
            }
        }

        System.out.println(isCycle(v, adj));

    }

    private static Map<Integer, LinkedList<Integer>> connect = new HashMap<>();

    public static boolean unweightedg(Integer src, Integer desti) {
        connect.putIfAbsent(src, new LinkedList<>());
        connect.get(src).add(desti);

        connect.putIfAbsent(desti, new LinkedList<>());
        connect.get(desti).add(src);

        return true;
    }

    static void print() {
        if (connect.size() == 0) {
            System.out.println(0);
        } else {
            for (Map.Entry<Integer, LinkedList<Integer>> entry : connect.entrySet()) {
                System.out.print(entry.getKey() + "=>  ");
                for (Integer x : entry.getValue()) {
                        System.out.print("[" + x + "]" + "<-->  ");
                }
                System.out.println();
            }
        }
    }

    public static boolean cycler_helper(Integer src , Set<Integer> visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);

        while(!q.isEmpty()){
            int rem = q.poll();

            if(!visited.contains(rem)){
                visited.add(rem);
            }else {
                return true;
            }

            for(Integer x : connect.get(rem)){
                if(!visited.contains(x))
                q.add(x);
            }
        }
        return false;
        
    }

    

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // if size of graph is null
        if (V == 0) {
            return false;
        }

        // creating the unweighted graph
        for (int i = 0; i < adj.size(); i++) {
            unweightedg(adj.get(i).get(0), adj.get(i).get(1));
            
        }
        print();

        // visited set
        Set<Integer> visited = new HashSet<>();

        for (Integer x : connect.keySet()) {
            if (!visited.contains(x)) {  
                if (cycler_helper(x, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }

}
