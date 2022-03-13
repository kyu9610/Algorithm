package back_joon.BinarySearch;
import java.util.*;

public class b2805 {

    static int N,M;
    static int min = 0;
    static int max = 0;
    static int[] tree;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 나무의 수
        N = sc.nextInt();
        // 나무의 길이
        M = sc.nextInt();

        // tree 배열 초기화
        tree = new int[N];
        for(int i=0;i<N;i++){
            tree[i] = sc.nextInt();

            if(max < tree[i]){
                max = tree[i];
            }
        }

        while(min < max){

            int mid = (min+max) / 2;
            long sum = 0;
            for(int treeHeight : tree){
                if(treeHeight - mid > 0){
                    sum = sum + (treeHeight - mid);
                }
            }

            if(sum < M){
                max = mid;
            }else{
                min = mid+1;
            }
        }

        System.out.println(min - 1);
    }

}
