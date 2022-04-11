package back_joon.BruteForce;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b14500 {

    private static int n,m,a[][],result;
    private static Boolean check[][];
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        check = new Boolean[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                check[i][j] = false;
            }
        }

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                check[i][j] = true;
                dfs(i,j,a[i][j],1);
                check[i][j] = false;
                check_exshape(i,j);
            }
        }

        System.out.println(result);

    }

    public static int max(int a,int b){
        return a > b ? a : b;
    }

    public static void dfs(int x,int y,int sum_value,int length){
        if(length >= 4){
            result = max(result,sum_value);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || ny < 1 || nx > n || ny > m){
                continue;
            }

            if(check[nx][ny] == false){
                check[nx][ny] = true;
                dfs(nx,ny,sum_value + a[nx][ny],length+1);
                check[nx][ny] = false;
            }
        }
    }

    public static void check_exshape(int x,int y){
        int sum_value = 0;

        // 1. ㅜ
        if(x>=1 && x+1<=n && y>=1 && y+2<=m){
            sum_value = a[x][y] + a[x][y+1] + a[x][y+2] + a[x+1][y+1];
            result = max(result,sum_value);
        }

        // 2. ㅏ
        if(x >= 1 && x+2 <=n && y>=1 && y+1<=m){
            sum_value = a[x][y] + a[x+1][y] + a[x+2][y] + a[x+1][y+1];
            result = max(result, sum_value);
        }

        // 3. ㅗ
        if(x-1 >= 1&& x <=n && y >=1 && y+2 <=m){
            sum_value = a[x][y] + a[x][y+1] + a[x][y+2] + a[x-1][y+1];
            result = max(result, sum_value);
        }

        // 4. ㅓ
        if(x-1 >= 1 && x+1 <=n && y >=1 && y+1 <=m){
            sum_value = a[x][y] + a[x][y+1] + a[x-1][y+1] + a[x+1][y+1];
            result = max(result, sum_value);
        }
    }
}
