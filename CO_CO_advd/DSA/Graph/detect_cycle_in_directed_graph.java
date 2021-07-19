package DSA.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import java.util.*;
import java.io.*;

import DSA.String.hashing;

public class detect_cycle_in_directed_graph {
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
        FastReader sc  = new FastReader();
        // number of nodes
        int node= sc.nextInt();
        // number of edges
        int edges = sc.nextInt();

        

        for(int i=1; i<=edges ;i++){
            
            int fnode = sc.nextInt();
            
            // if fnode is present or absent
            if(graphs.containsKey(fnode)){
                // connection value of a perticular edge
                Integer val = sc.nextInt();
                graphs.get(fnode).add(val);

                // creating node via value if fnode is present
                if(!graphs.containsKey(val)){
                    graphs.put(val, new LinkedList<>());
                }

            // if fnode is absent we need to add its value as a node as well need to add its value 
            // finally  we need to add val also as a node
            } else {
                graphs.put(fnode, new LinkedList<>());
                Integer val = sc.nextInt();
                graphs.get(fnode).add(val) ;

                if(!graphs.containsKey(val)){
                    graphs.put(val, new LinkedList<>());
                }
                
            }
        }

        System.out.println(cycle());

    }
    // graph map
    public static Map<Integer, LinkedList<Integer>> graphs = new HashMap<>();


    public static boolean cycle_helper(Integer src, Set<Integer> visited){
        // if not visited start searching
        if(!visited.contains(src)){
            
            // add since now you have visited node
            visited.add(src);

            // since didnot find the value we need to search for reoccurance in further nodes
            if(graphs.get(src).size()>0){
                for(Integer x : graphs.get(src)){

                    // if for a node reoccurance occur then return that else look for other branches of the base nodes
                    return cycle_helper(x, visited);
                }
                // if no branches have further expension for repetation the tree dries out and return false
            } else {
                return false;
            }
        } 
        // if reocuurance occur then ofcourse its a true
        return true;
    }

    // main function to see cyclization
    public static boolean cycle(){

        // if size is 0 return 0
        if(graphs.size() ==0){
            return false;
        } 

        // a set to tract the reoccurance of a node
        Set<Integer> visited = new HashSet<>();

        // seaching for reoccurance of every node since the graph is directed
        for(Integer x : graphs.keySet()){
            // if reoccureance occur return true
            if(cycle_helper(x, visited) == true){
                return true;
            // else need to start the cycle again with no visited value for a new node
            } else{
                visited.clear();
            }
        }

        return false;
    }

    
}
