package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fibonacci {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정수를 입력하세요 : ");
        int n = Integer.parseInt(br.readLine()); // 정수를 입력받아 저장
        int[] fib = new int[n]; // fibonacci 배열 정의

        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;

        System.out.println(fibo(n));
    }

    // n : 10 -> fibo(9) + fibo(8) -> fibo(8) + fibo(7) + fibo(7) + fibo(6) ->
    private static int fibo(int n){
        if(n<=2) {
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
