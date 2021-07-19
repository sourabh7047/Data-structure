package DSA.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class graphing {

    static class Graph<T> {

        private Map<T, LinkedList<pair<T>>> connect = new HashMap<>();

        public static class pair<T> implements Comparable<pair<T>> {
            T a;
            Integer b;
            boolean direction;

            public pair(T a, Integer b) {
                this.a = a;
                this.b = b;
            }

            public pair(T a, boolean direction) {
                this.a = a;
                this.direction = direction;
            }

            public pair(T a, Integer b, boolean direction) {
                this.a = a;
                this.b = b;
                this.direction = direction;
            }

            @Override
            public int compareTo(pair<T> o) {
                // TODO Auto-generated method stub
                    return this.b - o.b;
            
            }

            
        }

        boolean weightedg(T src, T desti, Integer weight, boolean direction) {
            connect.putIfAbsent(src, new LinkedList<>());

            connect.get(src).add(new pair<T>(desti, weight, direction));
            if (direction) {
                connect.get(desti).add(new pair<T>(src, weight, direction));
            }
            return true;

        }

        boolean unweightedg(T src, T desti, boolean direction) {
            connect.putIfAbsent(src, new LinkedList<>());
            connect.get(src).add(new pair<T>(desti, direction));

            connect.putIfAbsent(desti, new LinkedList<>());
            connect.get(desti).add(new pair<T>(src, direction));

            return true;
        }

        void bfs(T u) {

            Map<T, Boolean> visited = new HashMap<>();
            ArrayDeque<T> q = new ArrayDeque<>();
            q.add(u);

            while (!q.isEmpty()) {
                T Fele = q.poll(); // fornt element
                if (!visited.containsKey(Fele)) {
                    visited.put(Fele, true);
                    System.out.print(Fele + "-->");
                }

                for (pair<T> x : connect.get(u)) {
                    if (!visited.containsKey(x.a)) {
                        q.add(x.a);
                    }
                }

            }

        }

        void dfs_helper(T src, Map<T, Boolean> visited) {
            if (!visited.containsKey(src)) {
                visited.put(src, true);
                System.out.print(src + "-->");

                for (pair<T> x : connect.get(src)) {
                    dfs_helper(x.a, visited);
                }
            } else {
                return;
            }
        }

        void dfs_utility(T u) {
            Map<T, Boolean> visited = new HashMap<>();
            dfs_helper(u, visited); // jo list vary hoti ha usse hamesha as an argument do backtrack mai
        }

        void wprint() {
            if (connect.size() == 0) {
                System.out.println(0);
            } else {
                for (Map.Entry<T, LinkedList<pair<T>>> entry : connect.entrySet()) {
                    System.out.print(entry.getKey() + "=>  ");
                    for (pair<T> x : entry.getValue()) {

                        if (x.direction) {
                            System.out.print("[" + x.a + "," + x.b + "]" + "<-->  ");
                        } else {
                            System.out.print("[" + x.a + "," + x.b + "]" + "-->   ");
                        }
                    }
                    System.out.println();
                }
            }
        }

        void dikstra_helper()

        void dijkstra(T src) {
            System.out.println("dijkstra");
            int weight =0;
            PriorityQueue<pair<T>> q = new PriorityQueue<>();
            Set<T> visited = new HashSet<>();
            q.add(new pair<T>(src, 0));
            while (!q.isEmpty()) {
                pair<T> rem = q.poll();
                weight += rem.b;
                if (!visited.contains(rem.a)){
                    visited.add(rem.a);
                    System.out.print(rem.a+","+rem.b+"-->");
                    for(pair<T> x : connect.get(rem.a)){
                        pair<T> temp = x;
                        temp.b = weight+ temp.b;
                        
                        q.add(temp);
                    }
                } 
            } 

        }

        void print() {
            if (connect.size() == 0) {
                System.out.println(0);
            } else {
                for (Map.Entry<T, LinkedList<pair<T>>> entry : connect.entrySet()) {
                    System.out.print(entry.getKey() + "=>  ");
                    for (pair<T> x : entry.getValue()) {

                        if (x.direction) {
                            System.out.print("[" + x.a + "]" + "<-->  ");
                        } else {
                            System.out.print("[" + x.a + "]" + "-->   ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<Integer>();

        g.weightedg(0, 1, 10, false);
        g.weightedg(0, 3, 5, false);
        g.weightedg(1, 2, 10, false);
        g.weightedg(1, 0, 10, false);
        g.weightedg(2, 1, 10, false);
        g.weightedg(2, 3, 10, false);
        g.weightedg(3, 0, 5, false);
        g.weightedg(3, 2, 10 , false);
        g.weightedg(3, 4, 2, false);
        g.weightedg(4, 3, 3, false);
        g.weightedg(4, 5, 3, false);
        g.weightedg(4, 6, 8, false);
        g.weightedg(5, 4, 3, false);
        g.weightedg(5, 6, 3, false);
        g.weightedg(6, 4, 8, false);
        g.weightedg(6, 5, 3, false);

        g.print();
        g.bfs(0);
        System.out.println();
        g.dfs_utility(0);
        g.dijkstra(0);
    }
}
