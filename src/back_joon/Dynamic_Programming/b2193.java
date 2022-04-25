package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2193 {

    static long dp[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        for(int i = 0; i < N + 1; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        //dp[3] = dp[1] + dp[0] + 1;
        //dp[4] = dp[2] + dp[1] + 1;
        //dp[5] = dp[3] + dp[2] + dp[1] + 1;
        //dp[6] = dp[4] + dp[3] + dp[2] + dp[1] + 1;
        System.out.println(calc(N));
    }

    public static long calc(int num){
        if(dp[num] == -1){
            dp[num] = calc(num-1) + calc(num-2);
        }

        return dp[num];
    }
}
