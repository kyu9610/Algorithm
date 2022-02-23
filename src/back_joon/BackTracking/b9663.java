package back_joon.BackTracking;
import java.util.Scanner;

// N-Queen 문제
public class b9663 {

    static int[] arr;
    static int N;
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        backTracking(0);

        System.out.println(count);
    }

    public static void backTracking(int depth){
        if(N == depth){
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

    public static boolean possible(int col){

        for(int i=0;i<col;i++){
            // 같은 행에 존재 여부 확인
            if(arr[col] == arr[i]){
                return false;
            }

            // 대각선 위치에 존재 여부 확인
            else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
