package DSA.ARRAY;

import java.util.Random;
import java.util.Scanner;

public class KadaneAlgorithm8 {

    static boolean sign(int x, int y) {
        if((int)Math.pow(x, y) < 0) return true;
        else return false;
    }

    static void maxSubarraySum(int arr[], int n) {
        int start, end = 0;
        start = arr[0];
        int carry = 1;
        int profit = 0;
        int final_profit = 0;
        boolean switcher = false;
        for (int i = 1; i < n; i++) {

            if (i == carry) {
                if (sign(arr[i - 1], arr[i])) {
                    end = arr[i];
                    profit += arr[i];
                    carry++;
                } else if (i == n - 1) {
                    
                    if ((profit - final_profit) > 0) {
                        final_profit = profit;
                        profit = 0;
                    }
                } else {
                    switcher = true;

                }
            }
            if (switcher) {
                if (sign(arr[i - 1], arr[i]) == true) {
                    if ((profit - final_profit) > 0) {
                        final_profit = profit;
                        profit = 0;

                        continue;
                    } else {
                        start = arr[i];
                        profit = 0;
                        final_profit = 0;
                    }
                } else if (i == n - 1) {
                    if ((profit - final_profit) > 0) {
                        final_profit = profit;
                        profit = 0;
                    }
                } else {
                    end = arr[i];
                    profit += arr[i];

                }

            }

        }
        if (final_profit > 0)

        {
            System.out.print(start + " ");
            System.out.println(end);
        } else {
            System.out.println(arr[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        maxSubarraySum(arr, n);
    }
}
