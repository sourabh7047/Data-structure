package DSA.searchingAndSorting;

import java.util.*;
import java.io.*;

public class first_and_last_occurance_of_x {

    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        ArrayList<Long> index = new ArrayList<>();
        
        if(n==1 && arr[0] == x){
            index.add((long)0);
            index.add((long)0);
            return index;
            
        }
        

        long i=0;
        long j=n-1;
        while(i<=j){
            if(arr[(int)i] == x && arr[(int)j] == x){
                index.add(i);
                index.add(j);
                break;
            } else if(arr[(int)i] == x && arr[(int)j] !=x){
                j--;
            } else if(arr[(int)i] !=x && arr[(int)j] == x){
                i++;
            }else {
                i++;
                j--;
            }
        }

        if(index.size() == 0){
            index.add((long)-1);
            index.add((long)-1);

            return index;
        } else {
            return index;
        }
    }
}

