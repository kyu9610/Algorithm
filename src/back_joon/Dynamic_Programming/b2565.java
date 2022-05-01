package back_joon.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b2565 {

    static int[][] wire;
    static Integer[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        dp = new Integer[n];
        wire = new int[n][2];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int max = 0;

        for(int i=0;i<n;i++){
            max = Math.max(recur(i),max);
        }

        System.out.println(n - max);
    }

    static int recur(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for(int i=n+1;i<dp.length;i++){
                if(wire[n][1] < wire[i][1]){
                    dp[n] = Math.max(dp[n],recur(i) + 1);
                }
            }
        }

        return dp[n];
    }
}
