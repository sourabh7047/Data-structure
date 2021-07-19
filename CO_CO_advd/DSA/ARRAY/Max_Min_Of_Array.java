package DSA.ARRAY;

public class Max_Min_Of_Array {
    static class Pair{
        int Min;
        int Max;
    }

    static Pair getMinMax(int arr[], int n){
        Pair minmax = new Pair();
  
        if(n==1){
            minmax.Max = arr[0];
            minmax.Min = arr[0];
        } else if(n==2){
            if(arr[0]>arr[1]){
                minmax.Max = arr[0];
                minmax.Min = arr[1];
            } else {
                minmax.Max = arr[1];
                minmax.Min = arr[0];
            }
        } else {
            minmax.Min = arr[0];
            minmax.Max = arr[0];

            for(int i=1; i<n; i++){
                if(arr[i]>minmax.Max) minmax.Max = arr[i];
                else if(arr[i]<minmax.Min) minmax.Min = arr[i];
            }
        }
        return minmax;
    }

    static Pair tournamentMethod(int arr[], int start, int end){

        Pair minmax = new Pair();
        

        if(start == end){
            minmax.Max = arr[start];
            minmax.Min = arr[start];
            return minmax;
        } else if(end == start+1){
            if(arr[start]>arr[end]){
                minmax.Max = arr[start];
                minmax.Min = arr[end];
            } else {
                minmax.Max = arr[end];
                minmax.Min = arr[start];
            }
            return minmax;
        } else {
            int middle = (start+end)/2;
            
            Pair firsttournament = new Pair();
            Pair secondtournament = new Pair();
            firsttournament = tournamentMethod(arr, start, middle);
            secondtournament = tournamentMethod(arr, middle, end);

            if(firsttournament.Max>secondtournament.Max) minmax.Max = firsttournament.Max;
            else minmax.Max = secondtournament.Max;

            if(firsttournament.Min<secondtournament.Min) minmax.Min = firsttournament.Min;
            else minmax.Min = secondtournament.Min;

            
        }
 
        return minmax;

       
    }
    public static void main(String[] args) {
        int[] arr = {43,64,25,75,14};
        Pair answer = tournamentMethod(arr, 0, arr.length-1);
        System.out.println(answer.Max);
        System.out.println(answer.Min);
    }
}
