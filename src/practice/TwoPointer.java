package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        int ms = 0;
        int me = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;


        while(start < end){
            sum = arr[start] + arr[end];

            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                ms = start;
                me = end;
            }
            if(sum >= 0){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(arr[ms] + " " + arr[me]);
    }
}
