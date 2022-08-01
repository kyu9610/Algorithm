package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class string {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static boolean solution(String s){
        s = s.toLowerCase();
        if(s.length() == 4 || s.length() == 6){
            for(int i=0;i<s.length();i++){
                if('0' > s.charAt(i) || s.charAt(i) > '9'){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
