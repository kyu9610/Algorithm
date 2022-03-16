package back_joon.BFS;
import java.util.*;

public class b2178 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1 ,0 ,0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String s = sc.next();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0;i<4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY] || map[nextX][nextY] == 0){
                    continue;
                }

                q.add(new int[] {nextX,nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
