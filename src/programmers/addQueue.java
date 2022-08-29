package programmers;
import java.util.*;

public class addQueue {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,2,7,2},new int[]{4,6,5,1}));
        System.out.println(solution(new int[]{1,2,1,2},new int[]{1,10,1,2}));
        System.out.println(solution(new int[]{1,1},new int[]{1,5}));
    }

    private static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for(int idx=0;idx<queue1.length;idx++){
            sum1 += queue1[idx];
            q1.offer(queue1[idx]);
        }

        for(int idx=0;idx<queue2.length;idx++){
            sum2 += queue2[idx];
            q2.offer(queue2[idx]);
        }

        int count = 0;
        while(sum1 != sum2){
            count++;

            if(sum1 > sum2){
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
            }else{
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.offer(value);
            }

            if(count > (queue1.length + queue2.length) * 2) return -1;
        }

        return count;
    }
}
