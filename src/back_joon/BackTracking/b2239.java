package back_joon.BackTracking;
import java.util.*;

public class b2239 {
    static int[][] map = new int[9][9];
    static boolean end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<9;i++){
            String str = sc.next();
            for(int j=0;j<9;j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(depth == 81){
            end = true;
            return;
        }

        int y = depth / 9;
        int x = depth % 9;

        if(map[y][x] != 0){
            dfs(depth+1);
        }else{
            for(int i=1;i<=9;i++){
                if(!possible(y,x,i)){
                    continue;
                }
                map[y][x] = i;
                dfs(depth+1);
                if(end){
                    return;
                }
                map[y][x] = 0;
            }
        }

    }

    public static boolean possible(int row,int col,int value){
        for(int i=0;i<9;i++){
            if(map[row][i] == value){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(map[i][col] == value){
                return false;
            }
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for(int i=set_row;i<set_row+3;++i){
            for(int j=set_col;j<set_col+3;++j){
                if(map[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
