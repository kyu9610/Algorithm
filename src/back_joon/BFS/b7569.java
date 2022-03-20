package back_joon.BFS;
import java.util.*;

public class b7569 {

    static int N,M,H;
    static int[][][] tmt;
    static Queue<Point> q = new LinkedList<Point>();
    static int[] rowArr = {1,-1,0,0,0,0};
    static int[] colArr = {0,0,1,-1,0,0};
    static int[] heightArr = {0,0,0,0,1,-1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tmt = new int[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    tmt[i][j][k] = sc.nextInt();
                    if(tmt[i][j][k] == 1){
                        q.add(new Point(i,j,k));
                    }
                }
            }
        }

        bfs();
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Point point = q.poll();

            int height = point.height;
            int row = point.row;
            int col = point.col;

            for(int i=0;i<6;i++){
                int newRow = row + rowArr[i];
                int newCol = col + colArr[i];
                int newHeight = height + heightArr[i];

                if(newRow < 0 || newCol < 0 || newHeight < 0 || newRow >= N || newCol >= M || newHeight >= H){
                    continue;
                }

                if(tmt[newHeight][newRow][newCol] != 0){
                    continue;
                }

                tmt[newHeight][newRow][newCol] = tmt[height][row][col] + 1;
                q.add(new Point(newHeight,newRow,newCol));
            }
        }

        int max = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(tmt[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max,tmt[i][j][k]);
                }
            }
        }
        System.out.println(max-1);
    }
}

class Point{
    int height;
    int row;
    int col;

    public Point(int height,int row,int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}
