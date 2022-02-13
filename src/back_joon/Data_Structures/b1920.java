package back_joon.Data_Structures;
import java.util.Arrays;
import java.util.Scanner;

public class b1920 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        // 이분탐색을 위한 정렬
        Arrays.sort(arr);

        int M = sc.nextInt();


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            if(binarySearch(arr,sc.nextInt()) >= 0){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    /**
     * @param arr 정렬 된 배열
     * @param key 찾으려는 값
     * @return 찾으려는 값의 인덱스
     */
    public static int binarySearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = (low + high) / 2;

            if(key < arr[mid]){
                high = mid - 1;
            }else if (key > arr[mid]){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
