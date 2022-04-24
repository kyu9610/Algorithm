package back_joon.Dynamic_Programming;
import java.util.*;

public class b2748 {

    static long[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        arr = new long[N + 1];

        for(int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }

        arr[0] = 0;
        arr[1] = 1;
        System.out.println(Fib(N));
    }

    public static long Fib(int N) {
        if(arr[N] == -1) {
            arr[N] = Fib(N - 1) + Fib(N - 2);
        }
        return arr[N];
    }
}
