package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022 카카오 블라인드 - k진수에서 소수 개수 구하기
public class findPrimeNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution(n,k);
    }

    private static int solution(int n,int k){
        int answer = 0;
        String number = convert(n,k);
        int j=0;
        for(int i=0;i<number.length()-1;i=j){
            for(j=i+1;j<number.length() && number.charAt(j) != '0';j++);
            if (isPrime(Long.parseLong(number.substring(i,j))))
                answer++;
        }
        System.out.println(answer);
        return answer;
    }

    private static boolean isPrime(long num){
        if(num <= 1) return false;

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }

        return true;
    }
    // n을 k진수로 변환하는 함수 생성
    private static String convert(int n,int k){
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            sb.append(n%k);
            n /= k;
        }

        sb = sb.reverse();
        return sb.toString();
    }
}
