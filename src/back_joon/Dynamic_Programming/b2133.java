package back_joon.Dynamic_Programming;
import java.util.*;

public class b2133 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];

        dp[0] = 1;

        for(int i=2;i<=N;i=i+2){
            dp[i] = dp[i-2] * 3;
            for(int j=0;j<i-2;j=j+2){
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}
