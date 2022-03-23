package back_joon.BackTracking;
import java.util.Scanner;

public class b15652 {

    static int N,M;
    static int[] arr;
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

        for(int i = at;i<=N;i++){
            arr[depth] = i; // arr[0] = 1; arr[1] = 2;
            dfs(i,depth+1); //dfs(1,1); dfs(2,1);
        }
    }
}
