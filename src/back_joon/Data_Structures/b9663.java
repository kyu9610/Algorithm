package back_joon.Data_Structures;
import java.util.Scanner;

// N-Queen 문제
public class b9663 {
    static int N;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        backTracking(0);
        System.out.println(count);
    }

    public static void backTracking(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth] = i;
            if(possible(depth)){
                backTracking(depth+1);
            }
        }
    }

    public static boolean possible(int num){
        for(int i=0;i<num;i++){
            // 같은 행에 존재하는 경우
            if(arr[num] == arr[i]){
                return false;
            }

            // 대각선에 존재하는경우
            else if(Math.abs(num-i) == Math.abs(arr[num] - arr[i])){
                return false;
            }
        }

        return true;
    }
}
