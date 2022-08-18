package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BackTracking {
    static int arr[];
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        backTracking(0);

        System.out.println(count);
    }

    private static void backTracking(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth] = i;

            if(possible(depth)){
                backTracking(depth+1);
            }
        }
    }

    private static boolean possible(int col){
        for(int i=0;i<col;i++){
            if(arr[col] == arr[i]) {
                return false;
            }else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])){
                return false;
            }
        }

        return true;
    }
}
