package back_joon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class b2468 {

    static int N;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 행과 열의 개수
        map = new int[N][N];

        int max = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]); // 최대높이 파악
            }
        }

        int answer = 0;
        for(int i=1;i<=max;i++){
            int cnt = 0;
            visit = new boolean[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(!visit[j][k] && map[j][k] >= i){
                        cnt++;
                        dfs(i,j,k);
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }

        System.out.println(answer);
    }

    private static void dfs(int height,int x,int y){

        visit[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                continue;
            }

            if(!visit[nx][ny] && map[nx][ny] >= height){
                visit[nx][ny] = true;
                dfs(height,nx,ny);
            }
        }
    }
}
