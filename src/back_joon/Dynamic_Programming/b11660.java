package back_joon.Dynamic_Programming;
import java.util.*;

public class b11660 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int map[][] = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[N+1][N+1];

        for(int i=1; i<=N;i++){
            for(int j=1; j<=N;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int x1,x2,y1,y2;

        for(int i=0;i<M;i++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            sb.append(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]).append('\n');
        }

        System.out.println(sb);
    }

}
