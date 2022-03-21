package back_joon.BFS;
import java.util.*;

public class b7562 {

    static int T,N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2,-1,1,2,-2,-1,1,2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    static int lastX,lastY;
    static int count = 0;
    static Queue<Point> q = new LinkedList<Point>();

    static class Point{
        int x;
        int y;

        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int i=0;i<T;i++){

            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];

            int x = sc.nextInt();
            int y = sc.nextInt();

            lastX = sc.nextInt();
            lastY = sc.nextInt();

            bfs(new Point(x,y));
            System.out.println(map[lastX][lastY]);
        }
    }

    public static void bfs(Point p){
        q.clear();
        visited[p.x][p.y] = true;

        q.add(p);

        while(!q.isEmpty()){
            Point point = q.remove();

            int x = point.x;
            int y = point.y;

            if(x == lastX && y == lastY){
                break;
            }

            for(int j=0;j<8;j++){
                int newX = point.x + dx[j];
                int newY = point.y + dy[j];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N){
                    continue;
                }

                if(!visited[newX][newY]){
                    q.add(new Point(newX,newY));
                    visited[newX][newY] = true;
                    map[newX][newY] = map[x][y] + 1;
                }
            }
        }
    }
}
