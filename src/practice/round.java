package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class round {
    // 우 상 좌 하
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // 배열입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int group_value = Math.min(N,M) / 2;

        for(int i=0;i<R;i++){
            for(int j=0;j<group_value;j++){
                int x = j;
                int y = j;

                int temp = arr[x][y];

                int idx = 0;

                while(idx<4){
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if(nx >= j && ny >= j && nx < N-j && ny < M-j){
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }else{
                        idx++;
                    }
                }
                arr[j+1][j] = temp;
            }
        }

        // 배열출력
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
