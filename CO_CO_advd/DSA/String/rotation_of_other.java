package DSA.String;

import java.util.Scanner;

public class rotation_of_other {
    public static void main(String[] args) {
        String str1= "ABCDEFGH";
        String str2 = "EFGHABCD";

        if(str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        
        
    }
}
