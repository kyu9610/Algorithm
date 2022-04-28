package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2011 {

    static final int MOD = 1000000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int dp[] = new int[str.length() + 1];
        dp[0] = 1;

        for(int i=1;i<=str.length();i++){
            int one = str.charAt(i-1) - '0';
            if(one >= 1 && one <= 9){
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            if(i == 1) continue;

            int two = str.charAt(i-2) - '0';

            if(two == 0) continue;

            int ten = two * 10 + one;

            if(ten >= 10 && ten <= 26){
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }
}
