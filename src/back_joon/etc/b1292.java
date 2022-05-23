package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1292 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int arr[] = new int[1002];

        int count = 1;
        int sum = 0;

        for(int i=1;i<=1000;i++){
            for(int j=0;j<i;j++){
                if(count == 1001) break;
                arr[count] = i;
                count++;
            }
        }

        for(int i=start;i<=end;i++){
            sum = sum + arr[i];
        }

        System.out.println(sum);
    }
}
