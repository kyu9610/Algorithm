package back_joon.BruteForce;
import java.util.*;

public class b2789 {
    public static void main(String[] args) {
        int N,M;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] num = new int[N];

        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1; j<N ;j++){
                for(int k=j+1; k<N ;k++){
                    int sum = num[i] + num[j] + num[k];
                    if(max < sum && sum <= M){
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);

    }
}
