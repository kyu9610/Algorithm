package back_joon.BinarySearch;
import java.util.*;

public class b1072 {

    static long X,Y,Z;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        X = sc.nextLong();
        Y = sc.nextLong();

        Z = 100*Y/X;
        if(Z >= 99){
            System.out.println("-1");
        }else{
            long low = 0;
            long mid = 0;
            long high = 1000000000;
            while(low<=high){
                mid = (low+high)/2;
                if(Z<100*(Y+mid)/(X+mid)){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            System.out.println(low);
        }
    }
}
