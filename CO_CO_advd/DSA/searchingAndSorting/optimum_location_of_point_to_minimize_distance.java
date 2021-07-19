package DSA.searchingAndSorting;

import java.util.*;
import java.io.*;

public class optimum_location_of_point_to_minimize_distance {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public char nextChar() {
            return next().toCharArray()[0];
        }

    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        line l = new line(1, -1, -3);
		int points[][] = { { -3, -2 },
						{ -1, 0 },
						{ -1, 2 },
						{ 1, 2 },
						{ 3, 4 } };

        System.out.println(findOptimumCost(points, l));
        
    }

    static double sq(double x){return (x*x);}
    static double  EPS = (1e-6);

    static class point{
        int x;
        int y;

        public point(int x, int y){
            this.x = x;
            this.y =y;
        }
    }

    static class line{
        int a,b,c;

        public line(int a, int b, int c){
            this.a = a;
            this.b =b;
            this.c = c;
        }
    }
    // this is to find the euclidean distance by pythagorus therorum
    public static double euclidean(point p, double x, double y){
        return Math.sqrt(sq(p.x-x) + sq(p.y-y));
    }

    // function to find the y for the value of x find throught the ternary search
    public static double distance(line l, point[] pArr, double x){
         double y = -1 *(l.a*x+l.c)/l.b;
         return compute(pArr, x, y);
    }
    // compute the distance of all the point from the choosen cordinate on the line using the euclidean distance formula
    public static double compute(point[] pArr, double x, double y){
        double dist = 0;
        for(int i=0; i<pArr.length; i++){
            dist += euclidean(pArr[i], x, y);
        }

        return dist;
    }
    


    // ternary search used to find the maxima of minima of the given curve
    public static double Ternarysearch(line l, point[] pArr){
        double low =  -1e6;
        double high =  1e6;
        while(high-low>EPS){

            double mid1 = low + (high-low)/3;
            double mid2 = high - (high-low)/3;
    
            double dist1 =distance(l, pArr,  mid1);
            double dist2 = distance(l, pArr, mid2);
    
            if(dist1<dist2) high = mid2;
            else low = mid1;
        }

        return distance(l, pArr, high+low/2);

    }

    // function convert the 2D array into the 1D array
    static double findOptimumCost(int points[][], line l)
	{
		point[] p = new point[points.length];

		// converting 2D array input to point array
		for (int i = 0; i < points.length; i++)
			p[i] = new point(points[i][0], points[i][1]);

		return Ternarysearch(l, p);
	}
}
