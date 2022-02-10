package back_joon.Dynamic_Programming;
import java.util.*;

public class b1699 {
    public static int N;
    public static int[] sqrt;
    public static int count = 0; // 최소 개수
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        // 숫자 입력받기.
        N = scanner.nextInt();
        sqrt = new int[N+1];
        sqrt[0] = 0;
        // [2] = 2 [3] = 3 [4] = 1 [5] = 2 [6] = 3 [7] = 4 [8] = 2 [9] = 1 [10] = 2 [11] = 3 [12] = 3
        // [13] = 2 [14] = 3 [15] = 4 [16] = 1

        for(int i=1;i<=N;i++){
            sqrt[i] = i;
            for(int j=1; j*j<=i ; j++){
                if(sqrt[i] > sqrt[i-j*j]+1){
                    sqrt[i] = sqrt[i-j*j]+1;
                }
            }
        }

        System.out.println(sqrt[N]);
    }
}
