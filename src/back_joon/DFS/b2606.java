package back_joon.DFS;
import java.util.*;

public class b2606 {
    static int[][] node;
    static boolean[] visit;
    static int n,m,v;
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = 1;
        node = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = node[b][a] = 1;
        }

        System.out.println(dfs(1));
    }

    public static int dfs(int i){
        visit[i] = true;

        for(int j=0;j<=n;j++){
            if(node[i][j] == 1 && visit[j] == false){
                count++;
                dfs(j);
            }
        }
        return count;
    }
}
