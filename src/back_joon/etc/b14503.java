package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14503 {

    static int n,m;
    static int map[][];
    static int cnt = 0;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {-1,0,1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d);
        System.out.println(cnt);
    }

    public static void clean(int row,int col,int direction){
        if(map[row][col] == 0){
            map[row][col] = 2;
            cnt++;
        }

        boolean flag = false;
        int origin = direction;
        for(int i=0;i<4;i++){
            int new_d = (direction + 3) % 4;
            int new_r = row + dx[new_d];
            int new_c = col + dy[new_d];

            if(new_r > 0 && new_c > 0 && new_r < n && new_c < m){
                if(map[new_r][new_c] == 0){
                    clean(new_r,new_c,new_d);
                    flag = true;
                    break;
                }
            }
            direction = (direction + 3) % 4;
        }

        if (!flag) {
            int next_d = (origin + 2) % 4;
            int next_br = row + dx[next_d];
            int next_bc = col + dy[next_d];

            if (next_br > 0 && next_bc > 0 && next_br < n && next_bc < m) {
                if (map[next_br][next_bc] != 1) {
                    clean(next_br, next_bc, origin); // 바라보는 방향 유지한 채 후진
                }
            }
        }
    }
}
