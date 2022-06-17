package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coloringBook {
    static int n,m;
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int cnt = 0;
    static int[][] picture;
    static boolean[][] check;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        check = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(picture[i][j] != 0 && !check[i][j]){
                    numberOfArea++;
                    dfs(i,j);
                }
                if(cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;
                cnt = 0;
            }
        }

        System.out.print(numberOfArea + " ");
        System.out.println(maxSizeOfOneArea);
    }

    public static void dfs(int x,int y){
        if(check[x][y]) return;

        check[x][y] = true;
        cnt++;

        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newY < 0 || newX >= picture.length || newY >= picture[0].length) continue;

            if(picture[x][y] == picture[newX][newY] && !check[newX][newY]) dfs(newX,newY);
        }

    }
}
