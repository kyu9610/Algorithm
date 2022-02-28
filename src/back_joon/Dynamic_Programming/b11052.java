package back_joon.Dynamic_Programming;
import java.util.*;

public class b11052 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int arr[] = new int[N+1];
        int dp[] = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        dp[0] = 0;
        // 최대 금액 찾기
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
