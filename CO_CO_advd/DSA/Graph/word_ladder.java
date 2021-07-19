package DSA.Graph;

import java.util.*;

import DSA.String.string_in_a_grid;

import java.io.*;

public class word_ladder {
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
        int k = sc.nextInt();
        String beginword = sc.next();
        String endword = sc.next();

        List<String> dictionary = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            dictionary.add(sc.next());
        }

        System.out.println(ladder_length(beginword, endword, dictionary));

    }

    static Map<String, LinkedList<pair>> connect = new HashMap<>();

    public static class pair {
        String a;
        Integer b;

        public pair(String a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    static boolean unweightedg(String src, String desti, Integer weight) {
        connect.putIfAbsent(src, new LinkedList<>());
        connect.get(src).add(new pair(src, 1));

        connect.putIfAbsent(desti, new LinkedList<>());
        connect.get(desti).add(new pair(desti, 1));

        return true;
    }

    static boolean vertexA(String src) {
        connect.putIfAbsent(src, new LinkedList<>());
        return true;
    }

    public static int bfs(String begining, String endword, Map<String, Integer> visited) {
        ArrayDeque<pair> q = new ArrayDeque<>();

        q.add(new pair(begining, 0));

        while (!q.isEmpty()) {
            pair fele = q.poll();

            if (!visited.containsKey(fele.a)) {
                visited.put(fele.a, fele.b);
            }

            for (pair x : connect.get(fele.a)) {
                if (!visited.containsKey(x.a)) {
                    x.b = x.b + fele.b;
                    q.add(x);
                }

            }
        }

        return visited.get(endword);
    }

    public static int ladder_length(String beginword, String endword, List<String> wordlist) {
        Set<String> searchEnd = new HashSet<>();
        for (int i = 0; i < wordlist.size(); i++) {
            searchEnd.add(wordlist.get(i));
        }

        if (!searchEnd.contains(endword)) {
            return 0;
        }

        vertexA(beginword);
        for (int i = 0; i < wordlist.size(); i++) {
            vertexA(wordlist.get(i));
        }

        for (String x : connect.keySet()) {
            wordcheaker(x, searchEnd);
        }

        Map<String, Integer> visited = new HashMap<>();
        return bfs(beginword, endword, visited);
    }

    public static void wordcheaker(String src, Set<String> searchSet) {
        String temp;

        for (int i = 0; i < src.length(); i++) {
            for (int j = 97; j < 123; j++) {
                temp = src.substring(0, i) + (char) j + src.substring(i + 1, src.length());
                if (searchSet.contains(temp) && src != temp) {
                    unweightedg(src, temp, 1);
                }
            }
        }
    }
}