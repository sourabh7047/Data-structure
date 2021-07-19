package DSA.searchingAndSorting;

import java.util.HashSet;
import java.util.Set;

public class find_missing_and_repeating {
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

    public static void main(String[] args) {
        
    }

    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] res = new int[2];

        Set<Integer> hash  = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!hash.add(arr[i])){
                res[1]  = arr[i];
            }
        }

        for(int i=1; i<=n; i++){
            if(!hash.contains(i)){
                res[0] = i;
            }
        }

        return res;
    }
}
