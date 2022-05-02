package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17070 {

    static int n;
    static int map[][];
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        dfs(1,2,0);

        System.out.println(result);
    }

    public static void dfs(int x,int y,int dir){
        if(x == n && y == n){
            result++;
            return;
        }

        switch (dir){
            case 0:
                if(y+1 <= n && map[x][y+1] == 0){
                    dfs(x,y+1,0);
                }
                break;
            case 1:
                if(x+1 <= n && map[x+1][y] == 0){
                    dfs(x+1,y,1);
                }
                break;
            case 2:
                if(y+1 <= n && map[x][y+1] == 0){
                    dfs(x,y+1,0);
                }

                if(x+1 <= n && map[x+1][y] == 0){
                    dfs(x+1,y,1);
                }
                break;
        }

        if(y+1 <= n && x+1 <=n && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0){
            dfs(x+1,y+1,2);
        }
    }
}
