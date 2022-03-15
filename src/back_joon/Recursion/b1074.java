package back_joon.Recursion;
import java.util.*;

public class b1074 {

    static int N,r,c,cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int size = (int) Math.pow(2,N);

        int res = recursion(0,0,size);

        System.out.println(res);
    }

    public static int recursion(int nr,int nc,int size){
        if(size == 1){
            return 0;
        }

        if(r < nr + size / 2 && c < nc + size / 2){
            return recursion(nr,nc,size/2);
        }else if(r < nr + size / 2 && c < nc + size){
            return recursion(nr,nc + size/2,size/2) + (int) Math.pow(size/2,2);
        }else if(r < nr + size && c < nc + size / 2){
            return recursion(nr + size/2,nc,size/2) + (int) Math.pow(size/2,2) * 2;
        }else{
            return recursion(nr + size/2,nc + size/2,size/2) + (int) Math.pow(size/2,2) * 3;
        }
    }
}
