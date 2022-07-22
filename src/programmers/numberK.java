package programmers;
import java.util.*;

// 프로그래머스 - 코딩테스트 연습 K번째 수(정렬)
public class numberK {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i=0;i<commands.length;i++){
                int[] arr = new int[commands[i][1]-commands[i][0]+1];
                int cnt = 0;
                for(int j=commands[i][0]-1;j<=commands[i][1]-1;j++){
                    arr[cnt] = array[j];
                    cnt++;
                }
                Arrays.sort(arr);
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[j] + " ");
                }
                answer[i] = arr[commands[i][2]-1];
            }
            return answer;
        }
    }
}
