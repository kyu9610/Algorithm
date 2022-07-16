package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2018 카카오 블라인드 - [3차] n진수 게임
public class nGame {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 진법
        int t = Integer.parseInt(st.nextToken()); // 미리구할 숫자의 개수
        int m = Integer.parseInt(st.nextToken()); // 참가하는 인원
        int p = Integer.parseInt(st.nextToken()); // 순서

        solution(n,t,m,p);
    }

    private static String solution(int n,int t,int m,int p){
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;

        while(sb.length() < m*t){
            sb.append(Integer.toString(num++,n));
        }

        for(int i=p-1;i<m*t;i = i+m){
            answer.append(sb.charAt(i));
        }

        System.out.println(answer.toString().toUpperCase());
        return answer.toString().toUpperCase();
    }
}
