package back_joon.Dynamic_Programming;
import java.util.*;

public class b11066 {

    static int T, K;
    static int[] text,sum;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt(); // 테스트 케이스의 개수 입력

        for(int i=0;i<T;i++){

            K = sc.nextInt(); // 소설을 구성하는 장의 수
            text = new int[K+1]; // 파일의 크기를 저장하는 배열 변수
            sum = new int[K+1]; // 여태까지의 파일크기의 합을 저장하는 변수
            dp = new int[502][502]; // dp[i][j]를 i~j 까지 페이지를 합치는 값이라고 칭한다.

            // 각각의 파일의 크기 저장
            for(int j=1;j<=K;j++){
                text[j] = sc.nextInt();
                sum[j] = sum[j-1] + text[j];
            }

            // 양 옆의 페이지를 합치는 경우 초기화
            for(int j=0;j<K;j++){
                dp[j][j+1] = text[j] + text[j+1];
            }

            // 풀이
            for(int a=2;a<=K;a++){
                for(int b=1;a+b<= K;b++){
                    for(int c=b;c<a+b;c++){
                        if(dp[b][a+b] == 0){
                            dp[b][a+b] = dp[b][c] + dp[c+1][a+b] + sum(b,a+b);
                        }else{
                            dp[b][a+b] = Math.min(dp[b][a+b],dp[b][c] + dp[c+1][a+b] + sum(b,a+b));
                        }
                    }
                }
            }
            sb.append(dp[1][K]).append('\n');
        }

        System.out.println(sb);
    }

    private static int sum(int start,int end){
        if(start == 0){
            return sum[end];
        }

        return sum[end] - sum[start-1];
    }
}
