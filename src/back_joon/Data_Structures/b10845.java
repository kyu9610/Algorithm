package back_joon.Data_Structures;
import java.util.Scanner;

public class b10845 {
    static int[] queue;
    static int len = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        queue = new int[N];

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
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num){
        queue[len] = num;
        len++;
    }

    public static int pop(){
        if(len == 0){
            return -1;
        }else{
            int res = queue[0];
            for(int i=0;i<len-1;i++){
                queue[i] = queue[i+1];
            }
            len--;
            return res;
        }
    }

    public static int size(){
        return len;
    }

    public static int empty(){
        if(len == 0){
            return 1;
        }else{
            return 0;
        }
    }

    public static int front(){
        if(len == 0){
            return -1;
        }else{
            return queue[0];
        }
    }

    public static int back(){
        if(len == 0){
            return -1;
        }else{
            return queue[len-1];
        }
    }
}
