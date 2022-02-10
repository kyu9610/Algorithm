package back_joon.Greedy_Algorithm;
import java.util.*;

public class b11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성.
        int head_count; // 사람 수
        int[] time; // 사람 마다 걸리는 시간
        int wait_time = 0;
        int total_time = 0; // 총 걸리는 시간

        System.out.println("사람의 수를 입력하세요 : ");
        head_count = sc.nextInt(); // 사람 수를 입력으로 받는다.

        time = new int[head_count]; // 사람 수 만큼 시간을 받기위해 배열 생성.
        System.out.println("각 사람이 돈을 인출하는데 걸리는 시간을 입력하세요 ( 사람 수 만큼 입력 ) : ");
        for(int i=0; i<head_count; i++){
            time[i] = sc.nextInt(); // i번째 사람이 드는 시간을 저장한다.
        }

        Arrays.sort(time); // 시간이 적게 드는 순으로 정렬

        for(int i=0; i<head_count; i++){
            total_time = total_time + wait_time + time[i]; // 총 시간 = < i번째 사람이 기다린 시간 + i번째 사람이 걸린 시간 > 의 반복
            wait_time = wait_time + time[i]; // 앞에사람의 기다린시간 + 걸린시간 만큼 i+1 번째 사람이 기다리게 된다.
        }

        System.out.println(total_time);
    }
}
