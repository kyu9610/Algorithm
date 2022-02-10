package back_joon.Dynamic_Programming;
import java.util.*;

public class b1912 {
    public static void main(String[] args) {
        int count; // 정수의 개수
        int max; // 가장 큰 합
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        System.out.println("정수의 개수를 입력하세요 : ");

        count = sc.nextInt(); // 정수의 개수를 입력받는다.

        int[] num = new int[count]; // 개수만큼 배열을 생성

        // 수열 입력받기
        System.out.println("임의의 수열을 입력하세요");
        for(int i=0; i<count ; i++){
            num[i] = sc.nextInt();
        }

        max = num[0];
        int[] dp = new int[count];
        dp[0] = num[0];

        if(count == 1){
            System.out.println(max);
        }else{
            for(int i=1; i<count; i++){
                int temp = dp[i-1] + num[i];

                if(temp < num[i]){
                    dp[i] = num[i];
                }else{
                    dp[i] = temp;
                }

                if(max < dp[i]){
                    max = dp[i];
                }
            }
            System.out.println(max);
        }
    }
}
