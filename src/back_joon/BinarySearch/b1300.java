package back_joon.BinarySearch;
import java.util.*;

public class b1300 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long low = 1;
        long high = K;

        while(low < high){
            long mid = (low+high) / 2;
            long count = 0;


            for(int i=1;i<=N;i++){
                count = count + Math.min(mid/i , N);
            }

            if(K<=count){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        System.out.println(low);
    }
}
