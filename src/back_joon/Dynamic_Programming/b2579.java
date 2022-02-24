package back_joon.Dynamic_Programming;
import java.util.*;

public class b2579 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] stair = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            stair[i] = sc.nextInt();
        }

        dp[1] = stair[1];

        if(N>=2){
            dp[2] = stair[1] + stair[2];
        }

        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3] + stair[i-1]) + stair[i];
        }

        System.out.println(dp[N]);
    }
}
