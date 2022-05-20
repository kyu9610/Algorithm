package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1748 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 1;
        int temp = 0;
        int len = 10;

        for(int i=1;i<=num;i++){
            if(i == len){
                count++;
                len = len * 10;
            }
            temp = temp + count;
        }

        System.out.println(temp);
    }
}
