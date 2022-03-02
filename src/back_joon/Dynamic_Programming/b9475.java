package back_joon.Dynamic_Programming;
import java.util.Scanner;

public class b9475 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 갯수 입력
        int T = sc.nextInt();

        for(int i=0;i<T;i++){
            // 변수 생성 및 입력
            int N = sc.nextInt();
            int[][] cost = new int[2][N+1];
            int[][] dp = new int[2][N+1];


            // 스티커 점수 입력
            for(int j=0;j<2;j++){
                for(int k=1;k<=N;k++){
                    cost[j][k] = sc.nextInt();
                }
            }

            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            // 알고리즘
            for(int k=2;k<=N;k++){
                dp[0][k] = Math.max(dp[1][k-1] , dp[1][k-2]) + cost[0][k];
                dp[1][k] = Math.max(dp[0][k-1] , dp[0][k-2]) + cost[1][k];
            }

            System.out.println(Math.max(dp[0][N],dp[1][N]));
        }
    }
}
