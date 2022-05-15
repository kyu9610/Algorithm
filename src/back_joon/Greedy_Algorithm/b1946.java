package back_joon.Greedy_Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1946 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];

            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x] = y;
            }

            int count = 1;
            int standard = arr[1];
            for(int j=2;j<=n;j++){
                if(standard > arr[j]){
                    count++;
                    standard = arr[j];
                }
            }
            System.out.println(count);
        }
    }
}
