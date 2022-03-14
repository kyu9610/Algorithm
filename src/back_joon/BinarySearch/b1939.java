package back_joon.BinarySearch;
import java.util.*;

public class b1939 {

    static int N,M;
    static int S,E;
    static ArrayList<Node> list[];
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            max = Math.max(cost,max);
            min = Math.min(cost,min);
            list[x].add(new Node(y,cost));
            list[y].add(new Node(x,cost));
        }

        S = sc.nextInt();
        E = sc.nextInt();

        int result = 0;
        while(min <= max){
            int mid = (min+max) / 2;
            visited = new boolean[N+1];

            if(bfs(mid)){
                min = mid+1;
                result = mid;
            }else{
                max = mid-1;
            }
        }
        System.out.println(result);
    }

    public static boolean bfs(int mid){
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            if(temp == E){
                return true;
            }

            for(int i=0;i<list[temp].size();i++){
                if(list[temp].get(i).cost >= mid && visited[list[temp].get(i).n] == false){
                    visited[list[temp].get(i).n] = true;
                    q.offer(list[temp].get(i).n);
                }
            }
        }
        return false;
    }

    public static class Node{
        int n;
        int cost;

        public Node(int n,int cost){
            this.n = n;
            this.cost = cost;
        }
    }
}
