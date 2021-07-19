package DSA.ARRAY;

public class count_inversion2 {

    public static int merge(long[] arr, long start, long middle, long end ) {

        long n1 = middle + 1 - start;
        long n2 = end - middle;
        int count=0;

        long[] arr1 = new long[(int) n1];
        long[] arr2 = new long[(int) n2];

        for (int i = 0; i < n1; i++)
            arr1[i] = arr[(int) (start + i)];
        for (int i = 0; i < n2; i++)
            arr2[i] = arr[((int) (middle + 1) + i)];

        int temp1 = 0, temp2 = 0;
        int k = 0;
        while (temp1 < n1 && temp2 < n2) {
            if (arr2[temp2] > arr1[temp1]) {
                arr[k++] = arr1[temp1++];
            } else {
                arr[k++] = arr2[temp2++];
                count += 1;
            }
        }
        while (temp2 < n2) {
            arr[k] = arr2[temp2];
            temp2++;
            k++;
        }

        while (temp1 < n1) {
            arr[k] = arr1[temp1];
            temp1++;
            k++;
        }

        return count;
    }

    public static long divide(long[] arr, long start, long end) {
        // finding the middle element of the array
        int count =0;
        if (end > start) {
            long middle = (start + end) / 2;
            // recuring through each branch
            count +=divide(arr, start, middle);
            count +=divide(arr, middle + 1, end);
            count += merge(arr, start, middle, end);
        }

        return count;
    }

    static long inversionCount(long[] arr, long N) {
        long count = divide(arr, 0, N - 1);
        return count;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 20, 6, 7,5,8,11,3 };

        long count2 = inversionCount(arr, (long) arr.length);
        System.out.println(count2);
    }
}