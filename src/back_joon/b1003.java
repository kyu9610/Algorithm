package back_joon;
import java.util.*;

public class b1003 {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    static int N;
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 개수 입력받기.
        N = sc.nextInt();
        arr = new int[N];
        // 숫자입력받기.
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        for(int i=2;i<41;i++){
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        for(int i=0;i<N;i++){
            System.out.println(zero[arr[i]] + " " + one[arr[i]]);
        }
    }

}
