package back_joon.Data_Structures;
import java.util.*;

public class b1021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();

        // Deque 입력
        for(int i=1;i<=N;i++){
            deque.offer(i);
        }

        int count = 0;
        for(int i=0;i<M;i++){
            int num = scan.nextInt();

            int index = deque.indexOf(num);
            int half = deque.size() / 2;

            if(index <= half){
                while(num != deque.getFirst()){
                    deque.add(deque.removeFirst());
                    count++;
                }
            }else{
                while(num != deque.getFirst()){
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(count);
    }
}
