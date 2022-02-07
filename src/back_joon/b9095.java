package back_joon;
import java.util.*;

public class b9095 {
    static int T; // 정수의 개수
    static int num[];
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); // 정수의 개수 입력받기
        // 배열 생성
        num = new int[T];
        dp = new int[11];
        // 배열 초기화
        for(int i=0;i<T;i++){
            num[i] = sc.nextInt();
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int j=4;j<11;j++){
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }

        for(int i=0;i<T;i++){
            System.out.println(dp[num[i]]);
        }
    }
}
