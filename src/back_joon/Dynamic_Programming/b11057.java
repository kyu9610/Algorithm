package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11057 {

    static int dp[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10];

        for(int i=0;i<10;i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<10;i++){
            sum += dp[N][i];
        }

        System.out.println(sum % 10007);
    }

}
