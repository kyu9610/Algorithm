package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2745 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = st.nextToken();
        int notation = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int i=0;i<number.length();i++){
            char ch = number.charAt(i);
            if('A' <= ch && ch <= 'Z') {
                result = result * notation + (number.charAt(i) - 'A' + 10);
            }else {
                result = result * notation + (number.charAt(i) - '0');
            }
        }

        System.out.println(result);
    }
}
