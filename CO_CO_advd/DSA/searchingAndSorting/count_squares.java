package DSA.searchingAndSorting;


public class count_squares {
    static int countSquares(int N) {
        // code here
        double abs = Math.floor(Math.sqrt(N));
        double norm = Math.sqrt((N));
        if(abs ==  norm) return (int)abs -1;
        else return (int)abs;
       
    }
}
