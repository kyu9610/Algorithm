package back_joon.Dynamic_Programming;
import java.util.Scanner;

public class b1149_bottom_up {

    final static int Red = 0;
    final static int Blue = 1;
    final static int Green = 2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int Cost[][] = new int[N][3];

        for(int i=0;i<N;i++){
            Cost[i][Red] = sc.nextInt();
            Cost[i][Blue] = sc.nextInt();
            Cost[i][Green] = sc.nextInt();
        }


        for(int i=1;i<N;i++){
            Cost[i][Red] += Math.min(Cost[i-1][Blue],Cost[i-1][Green]);
            Cost[i][Blue] += Math.min(Cost[i-1][Red],Cost[i-1][Green]);
            Cost[i][Green] += Math.min(Cost[i-1][Red],Cost[i-1][Blue]);
        }

        System.out.println(Math.min(Cost[N-1][Red],Math.min(Cost[N-1][Blue],Cost[N-1][Green])));
    }
}
