package back_joon.Data_Structures;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int num = sc.nextInt();

            if(minHeap.size() == maxHeap.size()){
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }

            if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}
