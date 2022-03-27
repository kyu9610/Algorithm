package back_joon.Dynamic_Programming;
import java.util.*;

public class b2096 {

    static int N;
    static int[][] map;
    static int[][] minDp;
    static int[][] maxDp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        map = new int[N][3];
        minDp = new int[N][3];
        maxDp = new int[N][3];

        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 맨 윗줄 초기화
        for(int j=0;j<3;j++){
            minDp[0][j] = map[0][j];
            maxDp[0][j] = map[0][j];
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    minDp[i][j] = Math.min(minDp[i-1][j] + map[i][j],minDp[i-1][j+1]+ map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i-1][j] + map[i][j],maxDp[i-1][j+1]+ map[i][j]);
                }else if(j==1){
                    minDp[i][j] = Math.min(minDp[i-1][j-1] + map[i][j],Math.min(minDp[i-1][j]+ map[i][j],minDp[i-1][j+1]+ map[i][j]));
                    maxDp[i][j] = Math.max(maxDp[i-1][j-1] + map[i][j],Math.max(maxDp[i-1][j]+ map[i][j],maxDp[i-1][j+1]+ map[i][j]));
                }else{
                    minDp[i][j] = Math.min(minDp[i-1][j-1] + map[i][j],minDp[i-1][j]+ map[i][j]);
                    maxDp[i][j] = Math.max(maxDp[i-1][j-1] + map[i][j],maxDp[i-1][j]+ map[i][j]);
                }
            }
        }

        sb.append(Math.max(maxDp[N-1][0],Math.max(maxDp[N-1][1],maxDp[N-1][2]))).append(' ');
        sb.append(Math.min(minDp[N-1][0],Math.min(minDp[N-1][1],minDp[N-1][2])));
        System.out.println(sb);

    }
}
