package DSA.ARRAY;

import java.util.Arrays;

public class count_inversion {

    public static long merge(long[] arr,long start,long middle,long end){
        long length1  = (middle-start)+1;
        long length2 = end - middle;
        long count=0; 

        long[] divider1  = new long[(int)length1];
        long[] divider2 = new long[(int)length2];

        for(int i =0; i<length1; i++){
            divider1[i] = arr[(int)start+i];
        }

        for(int i=0; i<length2; i++){
            divider2[i] = arr[(int)middle+1+i];
        }

        

        int  temp1 = 0, temp2 =0, k=(int)start;
        while(temp1<length1 && temp2<length2){
            if(divider2[temp2] > divider1[temp1] || divider2[temp2]== divider1[temp1] ){
                arr[k++] = divider1[temp1++];
            } else if(divider2[temp2]<divider1[temp1]){
                arr[k++] = divider2[temp2++];
                count += length1- temp1;
            }
        }

        if(temp1<length1){
            for(int i =temp1; i<length1; i++){
                arr[k++] = divider1[i];
            }
            
        }

        if(temp2< length2){
            for(int i = temp2; i<length2; i++){
                arr[k++] = divider2[i];
             }
        }

        
        // for(int i=(int)start;i<end+1;i++){
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();
        

        return count;
    }

    public static long divide(long[] arr, long start, long end){
        long count = 0;
        if(start<end){
            long middle = (start+end)/2;
            count +=divide(arr, start, middle);
            count+= divide(arr,middle+1, end);
            count += merge(arr,  start,  middle,  end);
        }
        return count;
    }
    // first to have inversion count we have to go through the merge sort which divides the array in individual element and then
    // refill the main array by comparisions
    static long inversionCount(long arr[], long N){
        long count = divide(arr, 0, N-1);
        return count;
    }
    public static void main(String[] args) {
        long[] arr = {3,5,2,1,8,6,4,9};
        // 7,6,5,1,2,3,25,21,12,11,10,15,17
        long count = inversionCount(arr, arr.length);

        System.out.println(count);
    }
}
