package back_joon.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2512 {
    static int N;
    static int[] budget;
    static int maxBudget,sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 3 <= N <= 10000
        budget = new int[N];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }

        Arrays.sort(budget);

        maxBudget = Integer.parseInt(br.readLine());

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        if(sum <= maxBudget){
            return budget[N-1];
        }

        int start = 0;
        int end = maxBudget;


        while(start <= end){
            int current = 0;
            int mid = (start + end) / 2;

            for(int i=0;i<N;i++){
                if(budget[i] > mid){
                    current += mid;
                }else{
                    current += budget[i];
                }
            }

            if(current > maxBudget){
                end = mid-1;
            }else if(current < maxBudget){
                start = mid+1;
            }else{
                return mid;
            }
        }

        return end;
    }
}
