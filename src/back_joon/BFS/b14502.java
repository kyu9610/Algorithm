package back_joon.BFS;
import java.util.*;

public class b14502 {

    static class Virus{
        int x;
        int y;

        public Virus(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static int[][] map;
    static int[][] copy_map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        copy_map = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<Virus> q = new LinkedList<Virus>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy_map[i][j] = map[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy_map[i][j] == 2){
                    q.add(new Virus(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Virus v = q.remove();
            for(int i=0;i<4;i++){
                int newX = v.x + dx[i];
                int newY = v.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                    continue;
                }

                if(copy_map[newX][newY] == 0){
                    copy_map[newX][newY] = 2;
                    q.add(new Virus(newX,newY));
                }
            }
        }


        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy_map[i][j] == 0){
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
}
