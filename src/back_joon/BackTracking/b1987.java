package back_joon.BackTracking;
import java.util.Scanner;

public class b1987 {
    static int R,C;
    static int count = 0;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = { -1,     1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];

        for(int i=0;i<R;i++){
            String temp = sc.next();
            for(int j=0;j<C;j++){
                map[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(0,0,0);

        System.out.println(count);
    }

    public static void dfs(int x,int y,int cnt){
        if(visited[map[x][y]]){
            count = Math.max(count,cnt);
            return;
        }else{
            visited[map[x][y]] = true;
            for(int i=0;i<4;i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cy >= 0 && cx < R && cy < C){
                    dfs(cx,cy,cnt+1);
                }
            }

            visited[map[x][y]] = false;
        }
    }
}
