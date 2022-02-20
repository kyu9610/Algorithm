package back_joon.DFS;
import java.util.*;

public class b4963 {
    static int W,H;
    static int[][] node;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            W = sc.nextInt();
            H = sc.nextInt();

            if(W == 0 && H==0){
                break;
            }

            node = new int[H][W];
            visited = new boolean[H][W];

            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    node[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(node[i][j] == 1 && visited[i][j] == false){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int x,int y){
        visited[x][y] = true;

        for(int i=0;i<8;i++){
            int set_x = x + dx[i];
            int set_y = y + dy[i];

            if(set_x >= 0 && set_y >= 0 && set_x < H && set_y < W){
                if(node[set_x][set_y] == 1 && visited[set_x][set_y] == false){
                    dfs(set_x,set_y);
                }
            }
        }
    }
}
