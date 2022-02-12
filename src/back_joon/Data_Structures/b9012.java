package back_joon.Data_Structures;
import java.util.Scanner;
import java.util.Stack;

public class b9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int i=0;i<T;i++){
            String str = sc.next();
            sb.append(isVPS(str)).append('\n');
        }

        System.out.println(sb);
    }

    public static String isVPS(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){

            char c = str.charAt(i);

            if(c=='('){
                stack.push('c');
            }else if(stack.isEmpty()){
                return "NO";
            }else{
                stack.pop();
            }
        }

        if(stack.empty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}
