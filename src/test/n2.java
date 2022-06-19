package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class n2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int j = 0;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        while(j+cnt <= list.size()) {
            temp = new ArrayList<>(list);
            for(int i=0;i<cnt;i++){
                temp.remove(j);
            }
            min = Math.min(min, Collections.max(temp) - Collections.min(temp));
            j++;
        }

        System.out.println(min);
    }
}
