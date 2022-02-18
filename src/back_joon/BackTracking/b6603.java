package back_joon.BackTracking;
import java.util.*;

public class b6603 {
    static int N;
    static int[] arr;
    static boolean[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            N = sc.nextInt();

            if(N==0){
                break;
            }

            arr = new int[N];
            result = new boolean[N];
            sb = new StringBuilder();
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }

            dfs(0,0);
            System.out.println(sb);
        }
    }

    public static void dfs(int start, int depth){
        if(depth == 6){
            for(int i=0;i<N;i++){
                if(result[i]){
                    sb.append(arr[i]).append(' ');
                }
            }
            sb.append('\n');
        }

        for(int i=start;i<N;i++){
            result[i] = true;
            dfs(i+1,depth+1);
            result[i] = false;
        }
    }
}
