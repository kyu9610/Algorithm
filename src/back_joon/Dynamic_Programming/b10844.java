package back_joon.Dynamic_Programming;
import java.util.*;

public class b10844 {
    static Long[][] dp;
    static int N;
    final static int MOD = 1000000000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new Long[N+1][10];

        // 첫번째 자리수 초기화
        for(int i=0;i<10;i++){
            dp[1][i] = 1L;
        }

        long result = 0;

        for(int i=1;i<=9;i++){
            result += recur(N,i);
        }
        System.out.println(result % MOD);
    }

    public static long recur(int digit,int val){
        if(digit == 1){
            return dp[digit][val];
        }

        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = recur(digit-1,1);
            }else if(val == 9){
                dp[digit][val] = recur(digit-1,8);
            }else{
                dp[digit][val] = recur(digit-1,val-1) + recur(digit-1,val+1);
            }
        }
        return dp[digit][val] % MOD;
    }
}
