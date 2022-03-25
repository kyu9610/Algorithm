package back_joon.Recursion;
import java.util.*;

public class b2448 {

    static char[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        map = new char[N][2*N-1];

        for(int i=0;i<N;i++){
            Arrays.fill(map[i],' ');
        }

        drawStar(0,N-1,N);

        for(int i=0;i<N;i++){
            for(int j=0;j<2*N-1;j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void drawStar(int x,int y,int N){
        if(N==3){
            map[x][y] = '*';
            map[x+1][y-1] = map[x+1][y+1] = '*';
            map[x+2][y-2] = map[x+2][y-1] = map[x+2][y] = map[x+2][y+1] = map[x+2][y+2] = '*';
            return;
        }

        drawStar(x,y,N/2);
        drawStar(x+N/2,y-N/2,N/2);
        drawStar(x+N/2,y+N/2,N/2);

    }
}
