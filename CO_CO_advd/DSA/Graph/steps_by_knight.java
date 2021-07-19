package DSA.Graph;

import java.util.*;

import javax.print.attribute.standard.Destination;

import java.io.*;

public class steps_by_knight {
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
        FastReader sc= new FastReader();

        int N = sc.nextInt();
        int[] KnightPos = new int[2]; 
        int[] TargetPos = new int[2]; 

        for(int i=0; i<2; i++){
            KnightPos[i] = sc.nextInt();
        }

        for(int i=0; i<2; i++){
            TargetPos[i] = sc.nextInt();
        }

        System.out.println(minStepToReachTarget(KnightPos, TargetPos, N));    

    }

    static class pair{
        int x; 
        int y;

        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int destination(int KnightPosX, int KnightPosY, int[] TargetPos, int[][] visited,int N){
        
        ArrayDeque<pair> pos = new ArrayDeque<>();
        pos.add(new pair(KnightPosX, KnightPosY));
        visited[KnightPosX][KnightPosY] = 1;

        while(!pos.isEmpty()){
            int posx = pos.peekFirst().x;
            int posy = pos.peekFirst().y;
            pos.poll();

            // 1
            if(posx-2>=0 && posy-1>=0 && posx-2<N && posy-1<N && visited[posx-2][posy-1]== 0){
                visited[posx-2][posy-1] = visited[posx][posy] + 1;
                pos.add(new pair(posx-2, posy-1));
            }

            // 2
            if(posx-2>=0 && posy+1>=0 && posx-2<N && posy+1<N && visited[posx-2][posy+1]==0){
                visited[posx-2][posy+1] = visited[posx][posy] + 1;
                pos.add(new pair(posx-2, posy+1));
            }

            // 3
            if(posx-1>=0 && posy+2>=0 && posx-1<N && posy+2<N && visited[posx-1][posy+2]==0){
                visited[posx-1][posy+2] = visited[posx][posy] + 1;
                pos.add(new pair(posx-1, posy+2));
            }

            // 4
            if(posx+1>=0 && posy+2>=0 && posx+1<N && posy+2<N && visited[posx+1][posy+2]==0){
                visited[posx+1][posy+2] = visited[posx][posy] + 1;
                pos.add(new pair(posx+1, posy+2));
            }

            // 5
            if(posx+2>=0 && posy-1>=0 && posx+2<N && posy-1<N && visited[posx+2][posy-1]==0){
                visited[posx+2][posy-1] = visited[posx][posy] + 1;
                pos.add(new pair(posx+2, posy-1));

            }

            if(posx+2>=0 && posy+1>=0 && posx+2<N && posy+1<N && visited[posx+2][posy+1]==0){
                visited[posx+2][posy+1] = visited[posx][posy] + 1;
                pos.add(new pair(posx+2, posy+1));
            }

            if(posx-1>=0 && posy-2>=0 && posx-1<N && posy-2<N && visited[posx-1][posy-2]==0){
                visited[posx-1][posy-2] = visited[posx][posy] + 1;
                pos.add(new pair(posx-1, posy-2));
            }

            if(posx+1>=0 && posy-2>=0 && posx+1<N && posy-2<N && visited[posx+1][posy-2]==0){
                visited[posx+1][posy-2] = visited[posx][posy] + 1;
                pos.add(new pair(posx+1, posy-2));
            }
        }
        return visited[TargetPos[1]-1][TargetPos[0]-1] -1;
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int KnightPosX = KnightPos[1]-1;
        int KnightPosY = KnightPos[0]-1;

        int[][] visited = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visited[i][j] = 0;
            }
        }
        
        return destination(KnightPosX, KnightPosY,TargetPos, visited,N);

    }
}
