package back_joon;
import java.util.*;

public class b1932 {
    static int size;
    static int[][] triangle;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 삼각형 크기 입력받기
        size = scanner.nextInt();
        triangle = new int[size][size];
        dp = new Integer[size][size];

        // 삼각형 입력받기
        for(int i=0;i<size;i++){
            for(int j=0;j<i+1;j++){
                triangle[i][j] = scanner.nextInt();
            }
        }

        // 최하단 값 복사
        for(int i=0;i<size;i++){
            dp[size-1][i] = triangle[size-1][i];
        }

        System.out.println(find(0,0));

    }

    public static int find(int depth,int idx){
        if(depth == size-1){
            return dp[depth][idx];
        }

        if(dp[depth][idx] == null){
            dp[depth][idx] = Math.max(find(depth+1,idx),find(depth+1,idx+1)) + triangle[depth][idx];
        }
        return dp[depth][idx];
    }
}
