package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class middleChar {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String answer = "";

        answer = s.substring((s.length()-1)/2,s.length()/2+1);

        System.out.println(answer);
    }
}
