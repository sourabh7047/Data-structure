package DSA.ARRAY;

public class Reverse_Array {
    public static int[] reverse(int[] array, int start, int end){
        int temp =0;
        while(start !=end && start<end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++; 
            end--;}
        
        return array;
    }

    public static int[] reverse2(int[] array, int start, int end){
        while(start !=end && start<end){
            array[end] = array[start]+array[end] - (array[start] = array[end]);
            start++; 
            end--;}
        
        return array;
    }

    public static void main(String[] args) {
        int[] trial = {1,3,4,5,6,7};
        reverse2(trial, 0, trial.length-1);
        
        for(int x: trial) System.out.print(x+" ");
    }
}
