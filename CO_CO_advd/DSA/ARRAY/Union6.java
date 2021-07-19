package DSA.ARRAY;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// convert into the set for the intesection of two array
public class Union6 {

    static class SetCount {
        Set<Integer> unionOff = new HashSet<>();
        int count=0;
    }

    static SetCount doUnion(int a[], int n, int b[], int m) {
        // a.addAll(Arrays.asList(new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
        // Set<Integer> 
            // set1 = Sets.newHashSet(10, 20, 30, 40, 50); 
        SetCount union = new SetCount();

        for (int i = 0; i < n; i++) {
            if (union.unionOff.add(a[i]))
                union.count++;
        }

        for (int j = 0; j < m; j++) {
            if(union.unionOff.add(b[j])) union.count++; 
        }
        return union;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }
            SetCount result = new SetCount();
            
            result = doUnion(a, n, b, m);

            Iterator value = result.unionOff.iterator();
            while (value.hasNext())
                System.out.print(value.next() + " ");
            System.out.println();
            System.out.println(result.count);

        }
    }
}
