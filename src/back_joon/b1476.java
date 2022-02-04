package back_joon;
import java.util.*;

public class b1476 {
    public static void main(String[] args) {
        int E,S,M;
        int e=0,s=0,m=0;
        int year = 0;
        Scanner sc = new Scanner(System.in);


        // 세 수 E, S, M을 입력받는다.
        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        while(true){
            if(e == E && s == S && m == M){
                System.out.println(year);
                break;
            }

            e++;
            s++;
            m++;
            year++;
            if(e == 16){
                e = 1;
            }
            if(s == 29){
                s = 1;
            }
            if(m == 20){
                m = 1;
            }
        }
    }
}
