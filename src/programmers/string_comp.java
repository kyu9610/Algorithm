package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class string_comp {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            System.out.println(solution(br.readLine()));
        }
    }

    public static int solution(String s){
        int answer = s.length();

        for(int i=1;i<=s.length()/2;i++){
            int level = 1;
            String str = s.substring(0,i);
            StringBuilder sb = new StringBuilder();

            for(int j=i;j<=s.length();j+=i){
                String next = s.substring(j,j+i > s.length()? s.length() : j+i);
                if(str.equals(next)){
                    level++;
                }else{
                    sb.append((level != 1 ? level : "") + str);
                    str = next;
                    level = 1;
                }
            }

            sb.append(str);
            answer = Math.min(answer,sb.length());
        }
        return answer;
    }
}
