package back_joon.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1197 {

    static int total;
    static List<Node>[] list;
    static boolean[] visited;
    static class Node implements Comparable<Node>{
        int to;
        int value;

        public Node(int to,int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i=0;i<V+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
        }

        prim(1);
        System.out.println(total);
    }

    public static void prim(int start){
        Queue<Node> q = new PriorityQueue<>();

        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node pq = q.poll();
            int node = pq.to;
            int weight = pq.value;

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            total = total + weight;

            for(Node next : list[node]){
                if(!visited[next.to]){
                    q.add(next);
                }
            }
        }
    }
}
