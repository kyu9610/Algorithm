package back_joon.Dynamic_Programming;
import java.util.*;

public class b1463 {
    public static void main(String[] args) {
        int number; // 입력 숫자.
        //int min; // 최소 횟수
        int count = 0; // 연산 횟수.
        Scanner scan = new Scanner(System.in); // Scanner 객체 생성.

        number = scan.nextInt(); // 입력받기.

        int[] dp = new int[number+1];

        dp[0] = 0; // 숫자 0이 들어오면 0번의 연산
        dp[1] = 0; // 숫자 1이 들어오면 0번의 연산

        for(int i=2; i<=number; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        System.out.println(dp[number]);
    }
}
