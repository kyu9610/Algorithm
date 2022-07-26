package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 메모이제이션을 활용한 fibonaaci
public class fibonacci2 {
    static long[] fib;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정수를 입력하세요 : ");
        int n = Integer.parseInt(br.readLine()); // 정수를 입력받아 저장
        fib = new long[n+1]; // fibonacci 배열 정의

        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;

        System.out.println(fibo(n));
    }

    private static long fibo(int n){
        if(n<=1) {
            return n;
        }else if(fib[n] != 0){
            return fib[n];
        }else{
            return fib[n] = fibo(n-1) + fibo(n-2);
        }
    }
}
