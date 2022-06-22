package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bracket {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = Solution(br.readLine());
        System.out.println(answer);
    }

    public static boolean isBalanced(String str){
        int strLen = str.length();
        int open = 0;
        for(int i=0;i<strLen;i++){
            if(str.charAt(i) == '(') open++;
            else{
                if(open == 0) return false;
                open--;
            }
        }
        return true;
    }
    public static String Solution(String w){
        if(w.length() == 0) return "";

        int open = 0;
        int close = 0;

        for(char c : w.toCharArray()){
            if(c == '(') open++;
            else close++;
            if(open == close) break;
        }

        int uLen = open+close;
        String u = w.substring(0,uLen);
        String v = w.substring(uLen);
        if(isBalanced(u)){
            return u + Solution(v);
        }else{
            String uDash = "(" + Solution(v) + ")";

            for(int i=1;i<uLen-1;i++){
                if(u.charAt(i) == '('){
                    uDash += ")";
                }else{
                    uDash += "(";
                }
            }

            return uDash;
        }
    }
}
