package back_joon.DFS;
import java.util.*;

public class b1520 {
    static int N,M;
    static int[][] node;
    static int[][] dp;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        node = new int[N][M];
        dp = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                node[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }
    public static int dfs(int x,int y){
        if(x == N-1 && y == M-1){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }else {

            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X >= 0 && Y >= 0 && X < N && Y < M && node[x][y] > node[X][Y]) {
                    dp[x][y] += dfs(X, Y);
                }
            }

            return dp[x][y];
        }
    }
}
