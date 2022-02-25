package back_joon.Greedy_Algorithm;
import java.util.*;

public class b11047 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coin = new int[N];

        for(int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }

        int count = 0;

        for(int i = N - 1; i >= 0; i--) {

            // 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
            if(coin[i] <= K) {
                // 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
                count += (K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }

}