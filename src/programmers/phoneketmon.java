package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class phoneketmon {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solution(nums);
    }

    private static int solution(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int answer = 0;
        int count = nums.length / 2;
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        // case 1 : count <= hm.size() ==> answer = count;
        // case 2 : count > hm.size()
        answer = count <= hm.size() ? count : hm.size();
        System.out.println(answer);
        return answer;
    }
}
