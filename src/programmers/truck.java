package programmers;
import java.util.*;
public class truck {
    public static void main(String[] args) {
        solution(2,10,new int[]{7,4,5,6});
        solution(100,100,new int[]{10});
        solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10});
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int i=0;i < truck_weights.length;i++){
            int truck = truck_weights[i];

            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(q.size() == bridge_length){
                    sum -= q.poll();
                }else{
                    if(sum + truck <= weight){
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        q.add(0);
                        time++;
                    }
                }
            }
        }

        System.out.println(time + bridge_length);
        return time + bridge_length;
    }
}
