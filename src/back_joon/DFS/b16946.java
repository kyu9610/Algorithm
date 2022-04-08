package back_joon.DFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b16946 {

    static int N,M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int group[][];
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        int idx = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0 && group[i][j] == 0){
                    hm.put(idx,bfs(i,j,idx));
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(mapCount(i,j));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int mapCount(int x,int y){
        int sum = 1;
        HashSet<Integer> hs = new HashSet<>();

        if(map[x][y] == 0){
            return 0;
        }

        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                continue;
            }

            if(group[newX][newY] == 0){
                continue;
            }

            if(map[newX][newY] == 0){
                hs.add(group[newX][newY]);
            }
        }

        for(int idx : hs){
            sum = sum + hm.get(idx);
        }

        return sum % 10;
    }

    public static int bfs(int s,int e,int groupNum){
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(s,e));
        group[s][e] = groupNum;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                    continue;
                }

                if(map[newX][newY] == 0 && group[newX][newY] == 0){
                    q.offer(new Point(newX,newY));
                    group[newX][newY] = groupNum;
                    count++;
                }
            }
        }
        return count;
    }

    static class Point{
        int x;
        int y;

        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
