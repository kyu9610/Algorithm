package back_joon.Data_Structures;
import java.util.*;

public class b1339 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.next();
        }

        int[] num = new int[26];

        for(int i=0;i<N;i++){
            String t = arr[i];
            for(int j=0;j<t.length();j++){
                num[(t.charAt(j)-65)] += (int)Math.pow(10,(t.length()-j-1));
            }
        }

        Arrays.sort(num);
        int result = 0;
        for(int i=25,k=9;i>=0;i--,k--){
            if(num[i]==0){
                break;
            }
            result += (num[i] * k);
        }
        System.out.println(result);

    }
}
