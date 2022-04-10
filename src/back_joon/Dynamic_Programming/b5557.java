package back_joon.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b5557 {

    static int N,arr[];
    static long count[] = new long[21];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count[arr[0]] = 1;
        cal(0);
        System.out.println(count[arr[N-1]]);

    }

    public static void cal(int idx){
        if(idx == N-2){
            return;
        }
        long temp[] = new long[21];
        for(int i=0;i<=20;i++){
            if(count[i] != 0 ){
                if(i - arr[idx+1] >= 0){
                    temp[i-arr[idx+1]] += count[i];
                }
                if(i + arr[idx+1] <= 20){
                    temp[i+arr[idx+1]] += count[i];
                }
            }
        }
        count = temp.clone();
        cal(idx+1);
    }
}
