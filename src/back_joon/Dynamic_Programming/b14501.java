package back_joon.Dynamic_Programming;
import java.util.*;

public class b14501 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 남은 일 수
        int N = sc.nextInt();

        // 변수 초기화
        int time[] = new int[N];
        int cost[] = new int[N];
        int dp[] = new int[N+1];

        // N일 전까지 걸리는 상담의 일차별 시간, 비용 계산
        for(int i=0;i<N;i++){
            time[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++){
            if(i + time[i] <= N){
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i] + cost[i]);
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }

        System.out.println(dp[N]);
    }
}
