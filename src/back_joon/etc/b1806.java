package back_joon.etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1806 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int dp[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int first = 0, second = 0;
        while(true){
            if(sum >= s){
                sum = sum - arr[first++];
                min = Math.min(min,(second-first)+1);
            }else if(second == n){
                break;
            }else{
                sum = sum + arr[second++];
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }
    }
}
