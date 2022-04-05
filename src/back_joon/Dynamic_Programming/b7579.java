package back_joon.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class b7579 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 앱의 개수
        int M = Integer.parseInt(st.nextToken()); // 추가로 필요한 byte
        int ans = Integer.MAX_VALUE;

        int[] memory = new int[N];
        int[] cost = new int[N];
        int[][] dp = new int[N][100001];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i=0;i<N;i++){
            int mem = memory[i];
            int co = cost[i];

            for(int j=0;j<=10000;j++){
                if(i==0){
                    if(j>=co){
                        dp[i][j] = mem;
                    }
                }else{
                    if(j>=co){
                        dp[i][j] = Math.max(dp[i-1][j-co] + mem,dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if(dp[i][j] >= M){
                    ans = Math.min(ans,j);
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
