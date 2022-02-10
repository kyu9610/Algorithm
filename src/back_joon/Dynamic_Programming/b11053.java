package back_joon.Dynamic_Programming;
import java.util.*;

public class b11053 {
    static int size;
    static int seq[];
    static Integer dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 크기 구하기
        size = sc.nextInt();

        seq = new int[size];
        dp = new Integer[size];

        // 배열 초기화
        for(int i=0;i<size;i++){
            seq[i] = sc.nextInt();
        }

        for(int i=0;i<size;i++){
            find(i);
        }

        int max=dp[0];
        for(int i=1;i<size;i++){
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }

    public static int find(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for(int i=n-1;i>=0;i--){
                if(seq[i] < seq[n]){
                    dp[n] = Math.max(dp[n],find(i)+1);
                }
            }
        }
        return dp[n];
    }
}
