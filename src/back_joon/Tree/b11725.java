package back_joon.Tree;
import java.util.*;

public class b11725 {

    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=2;i<=N;i++){
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int v){
        visited[v] = true;

        for(int i : list[v]){
            if(!visited[i]){
                parents[i] = v;
                dfs(i);
            }
        }
    }
}
