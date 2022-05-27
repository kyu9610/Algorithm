package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int mul = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            switch(str.charAt(i)){
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;

                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;

                case ')':
                    if(stack.isEmpty() || stack.peek() != '('){
                        result = 0;
                        break;
                    }

                    if(str.charAt(i-1) == '('){
                        result += mul;
                    }
                    stack.pop();
                    mul /= 2;
                    break;

                case ']':
                    if(stack.isEmpty() || stack.peek() != '['){
                        result = 0;
                        break;
                    }

                    if(str.charAt(i-1) == '['){
                        result += mul;
                    }
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}
