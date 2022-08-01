package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jadenCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static String solution(String s){
        String answer = "";
        s = s.toLowerCase();

        answer += Character.toUpperCase(s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == ' '){
                answer += Character.toUpperCase(s.charAt(i));
            }else{
                answer += s.charAt(i);
            }

        }
        return answer;
    }
}
