package back_joon.BackTracking;
import java.util.Scanner;

public class b15650 {
    static int[] arr;
    static int N,M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1,0);

        System.out.println(sb);
    }

    public static void dfs(int at,int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=at;i<=N;i++){

            arr[depth] = i;
            dfs(i+1,depth+1);
        }
    }
}
