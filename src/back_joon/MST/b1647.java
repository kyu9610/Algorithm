package back_joon.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1647 {
    static List<Node> list[];
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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[x].add(new Node(y,w));
            list[y].add(new Node(x,w));
        }

        System.out.println(prim());
    }

    public static int prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        int dist = 0;
        int max = 0;

        while(!pq.isEmpty()){
            Node q = pq.poll();

            int next = q.to;
            int weight = q.value;

            if(visited[next]){
                continue;
            }

            visited[next] = true;
            max = Math.max(max,weight);
            dist += weight;

            for(Node node : list[next]){
                if(!visited[node.to]){
                    pq.add(node);
                }
            }
        }
        return dist - max;
    }
}
