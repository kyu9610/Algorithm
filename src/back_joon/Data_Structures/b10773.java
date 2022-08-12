package back_joon.Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b10773 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int number = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<K;i++){
            number = Integer.parseInt(br.readLine());
            if(number == 0){
                stack.pop();
            }else{
                stack.push(number);
            }
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.println(result);
    }
}
