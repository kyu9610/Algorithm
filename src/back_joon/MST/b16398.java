package back_joon.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b16398 {

    static int total = 0;
    static List<Point> list[];
    static boolean[] visited;
    static class Point implements Comparable<Point>{
        int to;
        int value;

        public Point(int to,int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int w = Integer.parseInt(st.nextToken());
                list[i].add(new Point(j,w));
            }
        }

        prim();
        System.out.println(total);
    }

    public static void prim(){
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0));

        while(!pq.isEmpty()){
            Point p = pq.poll();

            int node = p.to;
            int value = p.value;

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            total = total + value;

            for(Point next : list[node]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
    }
}
