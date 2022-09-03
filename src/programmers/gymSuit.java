package programmers;

import java.util.*;
public class gymSuit {
    public static void main(String[] args) {
        System.out.println(solution(5,new int[]{2,4},new int[]{1,3,5}));
        System.out.println(solution(5,new int[]{2,4},new int[]{3}));
        System.out.println(solution(3,new int[]{3},new int[]{1}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]+1 == reserve[j] || lost[i]-1 == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
