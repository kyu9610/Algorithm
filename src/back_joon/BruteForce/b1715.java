package back_joon.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        long num = 0;
        while(pq.size() > 1){
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1+temp2);
        }

        System.out.println(num);
    }
}
