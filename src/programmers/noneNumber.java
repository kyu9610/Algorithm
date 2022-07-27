package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class noneNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solution(numbers);
    }

    private static int solution(int[] numbers){
        int answer = 0;
        for(int i=0;i<10;i++){
            answer += i;
        }

        for(int i=0;i<numbers.length;i++){
            answer -= numbers[i];
        }

        System.out.println(answer);
        return answer;
    }
}
