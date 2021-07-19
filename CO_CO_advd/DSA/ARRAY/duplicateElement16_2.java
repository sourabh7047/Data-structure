package DSA.ARRAY;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class duplicateElement16_2 {
    public static int findduplicate(int[] nums){
        Set<Integer> hash = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!hash.contains(nums[i])) hash.add(nums[i]);
            else return nums[i];
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n+1];
        for(int i=0; i<n; i++) nums[i] =sc.nextInt();

        System.out.println(findduplicate(nums));
    }
}
