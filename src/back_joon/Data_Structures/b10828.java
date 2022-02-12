package back_joon.Data_Structures;
import java.util.*;

public class b10828 {
    static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 명령의 수 를 받는다

        for(int i=0;i<N;i++){
            String command = sc.next();

            switch(command){
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int number){
        stack.push(number);
    }

    public static int top(){
        if(stack.isEmpty()){
            return -1;
        }else{
            return stack.peek();
        }
    }

    public static int size(){
        return stack.size();
    }

    public static int empty(){
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    public static int pop(){
        if(!stack.isEmpty()){
            return stack.pop();
        }else{
            return -1;
        }
    }
}
