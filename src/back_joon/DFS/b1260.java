package back_joon.DFS;
import java.util.*;

public class b1260 {
    static int N,M,V;
    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        map = new int[1001][1001];
        check = new boolean[1001];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = map[b][a] = 1;
        }

        dfs(V);
        check = new boolean[1001];
        System.out.println();

        bfs();
    }

    public static void dfs(int v){
        check[v] = true;
        System.out.print(v + " ");

        for(int j=1;j<=N;j++){
            if(map[v][j] == 1 && check[j] == false){
                dfs(j);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(V);
        check[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i=1;i<=N;i++){
                if(map[temp][i] == 1 && check[i] == false){
                    queue.add(i);
                    check[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
