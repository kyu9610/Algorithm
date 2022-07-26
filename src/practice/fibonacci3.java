package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fibonacci3 {
    static long[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정수를 입력하세요 : ");
        int n = Integer.parseInt(br.readLine()); // 정수를 입력받아 저장
        dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}
