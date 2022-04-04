package back_joon.Greedy_Algorithm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Jewelry{
    int mass; // 무게
    int value; // 가격

    public Jewelry(int mass,int value){
        this.mass = mass;
        this.value = value;
    }
}

public class b1202 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석의 개수 입력
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수 입력

        Jewelry[] jewelries = new Jewelry[N]; // 보석의 개수만큼 보석정보 배열 생성
        // 반복문을 통해 보석의 정보 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(M,V);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if(o1.mass == o2.mass){
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
        });

        int[] bags = new int[K];
        for(int i=0;i<K;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags); // 가방 크기 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for(int i=0,j=0;i<K;i++){
            while(j<N && jewelries[j].mass <= bags[i]){
                pq.offer(jewelries[j++].value);
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
