package back_joon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14719 {

    static int[] block;
    static int ret,left,right;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        block = new int[w];
        ret = left = right = 0;

        for(int i=0;i<w;i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<w-1;i++){
            left = right = 0;

            for(int j=0;j<i;j++){
                left = Math.max(block[j],left);
            }

            for(int j=i+1;j<w;j++){
                right = Math.max(block[j],right);
            }

            if(block[i] < left && block[i] < right){
                ret += Math.min(left,right) - block[i];
            }
        }
        System.out.println(ret);
    }
}
