package back_joon.Dynamic_Programming;
import java.util.Scanner;

public class b11726 {

    final static int MOD = 10007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}
