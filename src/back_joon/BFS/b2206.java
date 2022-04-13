package back_joon.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b2206 {

    private static int n,m,ans;
    private static int[][] map;
    private static int[][] visit;
    private static int[] dx = {0,-1,0,1};
    private static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for(int i=0;i<n;i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        ans = Integer.MAX_VALUE;

        bfs(0,0);

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    public static void bfs(int x,int y){

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y,1,0));
        visit[x][y] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == n-1 && p.y == m-1){
                ans = p.dis;
                break;
            }

            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if(visit[nx][ny] <= p.drill){
                    continue;
                }

                if(map[nx][ny] == 0){
                    visit[nx][ny] = p.drill;
                    q.add(new Point(nx,ny,p.dis+1,p.drill));
                }else{
                    if(p.drill == 0){
                        visit[nx][ny] = p.drill + 1;
                        q.add(new Point(nx,ny,p.dis+1,p.drill+1));
                    }
                }
            }
        }

    }

    static class Point{
        int x;
        int y;
        int dis;
        int drill;

        public Point(int x,int y,int dis,int drill){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.drill = drill;
        }
    }
}
