package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Bfs {
    static int n,m,ans;
    static int[][] map, visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++){
            String temp = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        ans = Integer.MAX_VALUE;

        bfs(0,0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void bfs(int x,int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y,1,0));
        visited[x][y] = 0;

        while(!q.isEmpty()){

            Point p = q.poll();

            if(p.x == n-1 && p.y == m-1){
                ans = p.cnt;
                break;
            }

            for(int i=0;i<4;i++){
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= n || newY >= m){
                    continue;
                }

                if(visited[newX][newY] <= p.drill) continue;

                if(map[newX][newY] == 0){
                    visited[newX][newY] = p.drill;
                    q.add(new Point(newX,newY,p.cnt+1,p.drill));
                }else{
                    if(p.drill == 0){
                        visited[newX][newY] = p.drill+1;
                        q.add(new Point(newX,newY,p.cnt+1,p.drill+1));
                    }
                }
            }
        }
    }

    private static class Point{
        int x;
        int y;
        int cnt;
        int drill;

        public Point(int x, int y, int cnt, int drill){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.drill = drill;
        }
    }
}
