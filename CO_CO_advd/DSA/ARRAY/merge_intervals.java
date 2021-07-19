package DSA.ARRAY;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class merge_intervals {


    public static class pair implements Comparable<pair> {
        int st;
        int et;

        pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        public int compareTo(pair other){
            if(this.st != other.st){
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        int[][] result;
        pair[] pair = new pair[intervals.length];
        for(int i=0; i<intervals.length; i++){
            pair[i] = new pair(intervals[i][0], intervals[i][1]);
        }  
        Arrays.sort(pair);
       
        Stack<pair> sp = new Stack<>();
        for(int i=0; i<pair.length; i++){
            if(i==0){
                sp.push(pair[i]);
            } else {
                pair top = sp.peek();
                if(pair[i].st > top.st){
                    top.et = Math.max(pair[i].et, top.et);
                } else {
                    sp.push(pair[i]);
                }
            }
        }
        

        result  = new int[sp.size()][2];
        boolean switcher = true;
        for(int i=sp.size()-1; i>=0; i--){
            for(int j=0; j<2; j++){
                if(switcher){
                    result[i][j] = sp.peek().st;
                    switcher = !switcher;
                } else {
                    result[i][j] = sp.peek().et;
                    switcher = !switcher;
                    sp.pop();
                }
            }
        }
        return result;
    
        
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 0, 12 }, { 8, 10 }, { 15, 18 } };

        int[][] arr = merge(intervals);
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
