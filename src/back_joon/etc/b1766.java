package back_joon.etc;
import java.util.*;

public class b1766 {
    static int N,M;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(' ');

            for(int i=0;i<list[current].size();i++){
                int next = list[current].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
