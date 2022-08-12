package back_joon.Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b1927 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> x));

        for(int i=0;i<N;i++){
            int number = Integer.parseInt(br.readLine());
            if(number == 0){
                if(pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }else{
                pq.add(number);
            }
        }
    }
}
