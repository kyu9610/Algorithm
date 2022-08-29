package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class nQueen {
    static int[] arr;
    static int N;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        backTracking(0);

        System.out.println(count);
    }

    public static void backTracking(int depth){
        if(N == depth){
            count++;
            return;
        }

        for(int idx=0;idx<N;idx++){
            arr[depth] = idx;

            if(possible(depth)){
                backTracking(depth+1);
            }
        }
    }

    private static boolean possible(int col){
        for(int idx=0;idx<col;idx++){

            if(arr[col] == arr[idx]){
                return false;
            }else if(Math.abs(col-idx) == Math.abs(arr[col] - arr[idx])){
                return false;
            }
        }

        return true;
    }
}
