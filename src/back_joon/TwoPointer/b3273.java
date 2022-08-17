package back_joon.TwoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b3273 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬을 한다.

        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = N-1;
        int sum = 0;

        while(start < end){
            sum = arr[start] + arr[end];
            if(sum == x){
                count++;
            }

            if(sum <= x){
                start++;
            }else{
                end--;
            }
        }


        System.out.println(count);
    }
}
