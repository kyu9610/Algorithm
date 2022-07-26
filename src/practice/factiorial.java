package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class factiorial {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정수를 입력하세요 : ");
        int n = Integer.parseInt(br.readLine()); // 정수를 입력받아 저장

        System.out.println(calcFact(n));
    }

    private static int calcFact(int n){
        if(n == 1){
            return 1;
        }
        return n * calcFact(n-1);
    }
}
