package back_joon.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1922 {

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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        prim(1);
        System.out.println(total);
    }

    public static void prim(int start){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node q = pq.poll();

            int node = q.to;
            int value = q.value;

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            total = total + value;

            for(Node next : list[node]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
    }
}
