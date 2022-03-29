package back_joon.Dynamic_Programming;
import java.util.Scanner;

public class b10942 {

    static int N,M;
    static int[] arr;
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];

        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        solve(arr,N);

        M = sc.nextInt(); // 테스트 케이스 개수 입력
        // 테스트 케이스 만큼 반복문
        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(dp[x][y]){
                sb.append('1').append('\n');
            }else{
                sb.append('0').append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void solve(int[] arr,int N){

        for(int i=1;i<=N;i++){
            dp[i][i] = true;
        }

        for(int i=1;i<N;i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for(int i=2;i<N;i++){
            for(int j=1;j<=N-i;j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i] = true;
                }
            }
        }
    }
}
