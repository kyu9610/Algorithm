package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = arr.length;
        int i = length - 1;
        int k = 0;
        int max = 0;
        int answer = -1;

        while(i>0){
            if(arr[i] == 1){
                k++;
                if(k >= max){
                    max = k;
                    answer = i;
                }
            }else{
                k = 0;
            }
            i--;
        }

        if(arr[i] == 1 && k+1 >= max){
            answer = 0;
        }

        System.out.println(answer);

    }
}
