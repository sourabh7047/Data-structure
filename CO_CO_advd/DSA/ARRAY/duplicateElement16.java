package DSA.ARRAY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class duplicateElement16 {

    static <T> void reverse(T[] arr, int l, int r) {
        for (int i = l; i < l + (r - l) / 2; i++) {
            T temp = arr[i];
            arr[i] = arr[r - i + l - 1];
            arr[r - i + l - 1] = temp;
        }
    }

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

        public static int[] toArray(Set<Integer> set) {
            int[] setToarray = new int[set.size()];
            int i = 0;
            for (int element : set)
                setToarray[i++] = element;
            return setToarray;
        }
    }

    public static Integer findduplicate(int[] arr) {
        ArrayList<Integer> new_arr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            new_arr.add(arr[i]);
        }
        Set<Integer> set_arr = new_arr.stream().collect(Collectors.toSet());
        ArrayList<Integer> noduplicate_arrlist = new ArrayList<>(set_arr);

        for (int i = 0; i < noduplicate_arrlist.size(); i++) {
            for (int j = 0; j < new_arr.size(); j++) {
                if (noduplicate_arrlist.get(i) == new_arr.get(j)) {
                    new_arr.remove(j);
                    break;
                }
            }
        }

        for(Integer x : new_arr){
            System.out.println(x);
        }

        return new_arr.get(0);

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findduplicate(arr));
    }
}