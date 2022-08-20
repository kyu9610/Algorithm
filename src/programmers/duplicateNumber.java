package programmers;
import java.util.*;

public class duplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }

    public static int[] solution(int[] arr) {
        int value = -1;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != value){
                answer.add(arr[i]);
                value = arr[i];
            }
        }

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i) + " ");
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
