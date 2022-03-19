package back_joon.BFS;
import java.util.*;

public class b7576 {

    static int N,M;
    static int[][] tmt;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        tmt = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmt[i][j] = sc.nextInt();
            }
        }

        bfs(tmt,N,M);
    }

    public static void bfs(int[][] tmt,int N,int M){
        Queue<DOT> q = new LinkedList<DOT>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmt[i][j] == 1){
                    q.add(new DOT(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            DOT dot = q.poll();

            for(int i=0;i<4;i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }

                if(tmt[nextX][nextY] != 0){
                    continue;
                }

                tmt[nextX][nextY] = tmt[dot.x][dot.y] + 1;
                q.add(new DOT(nextX,nextY));
            }
        }

        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmt[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max,tmt[i][j]);
            }
        }

        System.out.println(max-1);
    }

    public static void print(int[][] tmt,int N,int M){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(tmt[i][j] + " ");
            }
            System.out.println();
        }
    }

}

class DOT{
    int x;
    int y;

    public DOT(int x,int y){
        this.x = x;
        this.y = y;
    }
}
