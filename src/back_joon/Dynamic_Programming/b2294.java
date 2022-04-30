package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class b2294 {

    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coin = new int[n+1];
        for(int i=1;i<=n;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        dp = new int[k+1];

        for(int i=1;i<=k;i++){
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1;i<=n;i++){
            for(int j=coin[i];j<=k;j++){
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE-1){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }

    }
}
