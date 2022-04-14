package back_joon.BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b2583 {

    private static int m,n,k;
    private static int count = 0;
    private static int[][] map;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int a=y1;a<y2;a++){
                for(int b=x1;b<x2;b++){
                    map[a][b] = 1;
                }
            }
        }

        list = new ArrayList<Integer>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 0){
                    count = 0;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(Integer c : list){
            System.out.print(c + " ");
        }
    }

    public static void dfs(int r,int c){
        map[r][c] = 1;
        count++;

        for(int i=0;i<4;i++){
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n){
                continue;
            }else{
                if(map[nr][nc] == 0){
                    dfs(nr,nc);
                }
            }
        }
    }
}
