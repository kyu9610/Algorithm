package back_joon.BinarySearch;
import java.util.*;

public class b2110 {

    static int N,C;
    static int[] home;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 집의 개수 N, 공유기 개수 C 입력
        N = sc.nextInt();
        C = sc.nextInt();

        home = new int[N];
        for(int i=0;i<N;i++){
            home[i] = sc.nextInt();
        }

        Arrays.sort(home);

        int lo = 1;
        int hi = home[N-1] - home[0] + 1;

        while(lo < hi){

            int mid = (lo+hi) / 2;

            if(install(mid) < C){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        System.out.println(lo-1);
    }

    public static int install(int distance){

        int count = 1;
        int last = home[0];

        for(int i=1;i< home.length;i++){
            int locate = home[i];

            if(locate - last >= distance){
                count++;
                last = locate;
            }
        }

        return count;
    }
}
