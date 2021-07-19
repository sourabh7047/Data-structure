package DSA.String;

import java.util.*;
import java.lang.*;
import java.io.*;

public class edit_distance {

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
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(editDistance(s1, s2));

        }

    }

    public static int editDistance(String s, String t) {
        // Code here
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i=0; i<s.length()+1; i++){
            dp[i][0] = i;
            System.out.println(dp[i][0]);
        }

        for(int i=0; i<t.length()+1; i++){
            dp[0][i] = i;
        }

        for(int i=1; i<s.length()+1; i++){
            for(int j=1; j<t.length()+1; j++){
                // we compared the i-1 and j-1 th element because we assumed that string will start with a gap whereas in the string
                // there is no gap so in dp if the two element  have indices 2,3 in string they have indices 1,2. hence , 
                // if 2,3 => 1,2 matches we need values form 1,2 => 0,1
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1],  Math.min(dp[i-1][j-1], dp[i-1][j]))+1;   
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    
}


// use of queue
// public static int editDistance(String s, String t) {

//     int cost = 0;
//     // Code here

//     // queue for first in and first out
//     Queue<Character> characters = new LinkedList<>();

//     // filling the queue through all the character of string one
//     for (char i : s.toCharArray()) {
//         characters.add(i);
//     }

//     // treversing over the string 2
//     for (int i = 0; i < t.length(); i++) {

//         // peek if the character at i in string 2 is present at the first index of the first string
//         if (characters.peek() == t.charAt(i)) {

//             // if yse then nothing has to be done for this portion hence remove it
//             characters.remove(characters.peek());

//             // if due to continue removal string gets empty then break the looping
//             if(characters.size()==0) break;

//             // else continue
//             continue;
        
//             // else if first string contains the element at the ith index of the second string but at other position 
//             // not at the top then collect the cost for replacement and remove the element from the first string
//             // again if the size of the character become 0 then break the loop
//         } else if (characters.contains(t.charAt(i))) {
//             characters.remove(t.charAt(i));
//             if(characters.size()==0) break;
//             cost++;
//         } else {
//             cost++;
//         }
//     }
//     return cost;
// }