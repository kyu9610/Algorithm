package back_joon.Dynamic_Programming;
import java.util.*;

public class b12865 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int W[] = new int[N+1];
        int V[] = new int[N+1];
        //int dp[][] = new int[N+1][K+1];

        int dp[] = new int[K+1];

        for(int i=1;i<=N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            W[i] = a;
            V[i] = b;
        }

//        for(int i=1;i<=N;i++){
//            for(int j=1;j<=K;j++){
//                if(W[i] > j){
//                    dp[i][j] = dp[i-1][j];
//                }else{
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-W[i] + V[i]]);
//                }
//            }
//        }

        for(int i=1;i<=N;i++){
            for(int j=K; j-W[i] >= 0;j--){
                dp[j] = Math.max(dp[j],dp[j-W[i]] + V[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
