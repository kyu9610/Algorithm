package back_joon.Dynamic_Programming;
import java.util.Scanner;

public class b1149 {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] Cost;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Cost = new int[N][3];
        dp = new int[N][3];

        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                Cost[i][j] = sc.nextInt();
            }
        }

        dp[0][Red] = Cost[0][Red];
        dp[0][Green] = Cost[0][Green];
        dp[0][Blue] = Cost[0][Blue];

        System.out.println(Math.min(paint(N-1,Red),Math.min(paint(N-1,Blue),paint(N-1,Green))));
    }

    static int paint(int N, int color){

        if(dp[N][color] == 0){
            if(color == Red){
                dp[N][Red] = Math.min(paint(N-1,Blue),paint(N-1,Green)) + Cost[N][Red];
            }else if(color == Blue){
                dp[N][Blue] = Math.min(paint(N-1,Red),paint(N-1,Green)) + Cost[N][Blue];
            }else{
                dp[N][Green] = Math.min(paint(N-1,Blue),paint(N-1,Red)) + Cost[N][Green];
            }
        }

        return dp[N][color];
    }
}
