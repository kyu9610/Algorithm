package back_joon.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class b1937 {

    static int N;
    static int[][] forest;
    static int[][] dp;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ans = Math.max(ans,dfs(i,j));
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x,int y){
        if(dp[x][y] != 0){
            return dp[x][y];
        }

        dp[x][y] = 1;

        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= N){
                continue;
            }

            if(forest[x][y] < forest[newX][newY]){
                dp[x][y] = Math.max(dp[x][y],dfs(newX,newY) + 1);
            }
        }
        return dp[x][y];
    }
}
