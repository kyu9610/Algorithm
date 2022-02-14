package back_joon.Data_Structures;
import java.util.*;

public class b10815 {
    static int[] card;
    static int M;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        card = new int[N];
        for(int i=0;i<N;i++){
            card[i] = sc.nextInt();
        }

        Arrays.sort(card);

        M = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(binarySearch(sc.nextInt())).append(' ');
        }

        System.out.println(sb);
    }

    public static int binarySearch(int key){
        int low = 0;
        int high = card.length-1;
        int mid;


        while(low <= high){
            mid = (low+high)/2;

            if(key < card[mid]){
                high = mid-1;
            }else if(key > card[mid]){
                low = mid+1;
            }else{
                return 1;
            }
        }

        return 0;
    }
}
