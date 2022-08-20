package practice;

import java.util.Stack;

public class StackToQueue {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=0;i<10;i++){
            stack1.add(i);
        }

        for(int i=0;i<10;i++){
            stack2.add(stack1.pop());
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
    }
}
