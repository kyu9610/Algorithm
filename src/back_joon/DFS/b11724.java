package back_joon.DFS;
import java.util.*;

public class b11724 {
    static int N,M;
    static int[][] node;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        node = new int[N+1][N+1];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = node[b][a] = 1;
        }

        visit = new boolean[N+1];

        int result = 0;

        for(int i=1; i<=N; i++){
            if(visit[i] == false){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int index){
        visit[index] = true;
        for(int i=1;i<=N;i++){
            if(node[index][i] == 1 && visit[i] == false){
                dfs(i);
            }
        }
    }
}
