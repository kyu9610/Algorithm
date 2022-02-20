package back_joon.DFS;
import java.util.*;

public class b10026 {
    static int N;
    static char[][] node;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N x N 개수받기
        N = sc.nextInt();

        // 노드 초기화
        node = new char[N][N];
        visited = new boolean[N][N];

        // 입력
        for(int i=0;i<N;i++){
            String temp = sc.next();
            for(int j=0;j<N;j++){
                node[i][j] = temp.charAt(j);
            }
        }

        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == false){
                    dfs(i,j);
                    count++;
                }
            }
        }

        int normal_count = count;
        count = 0;
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(node[i][j] == 'G'){
                    node[i][j] = 'R';
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == false){
                    dfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(normal_count + " " + count);
    }

    public static void dfs(int x,int y){
        visited[x][y] = true;
        char temp = node[x][y];

        for(int i=0;i<4;i++){
            int X = x + dx[i];
            int Y = y + dy[i];

            if(X >=0 && Y >=0 && X < N && Y < N){
                if(node[X][Y] == temp && visited[X][Y] == false){
                    dfs(X,Y);
                }
            }
        }
    }
}
