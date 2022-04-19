package back_joon.MST;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int num;
    double x;
    double y;

    public Point(int num,double x,double y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    double weight;

    public Edge(int start,int end,double weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight < o.weight){
            return -1;
        }
        return 1;
    }
}
public class b4386 {

    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Point p[] = new Point[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            p[i] = new Point(i,a,b);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                pq.offer(new Edge(i,j,Math.sqrt(Math.pow(p[i].x - p[j].x,2) + Math.pow(p[i].y - p[j].y,2))));
            }
        }

        double weight = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();

            int p1 = find(now.start);
            int p2 = find(now.end);

            if(p1 != p2){
                union(p1,p2);
                weight += now.weight;
            }
        }

        System.out.printf("%.2f",weight);
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a,int b){
        parent[a] = b;
    }
}
