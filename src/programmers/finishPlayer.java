package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 코딩테스트 연습 - 완주하지 못한 선수(해쉬)
public class finishPlayer {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("input participant count : ");
        int n = Integer.parseInt(br.readLine());
        String[] participant = new String[n];
        System.out.print("input participant : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            participant[i] = br.readLine();
        }

        System.out.print("input completion count : ");
        int m = Integer.parseInt(br.readLine());
        String[] completion = new String[n];
        System.out.print("input completion : ");
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            completion[i] = br.readLine();
        }

        solution(participant,completion);
    }

    private static String solution(String[] participant,String[] completion){
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        for(String person : participant){
            hm.put(person,hm.getOrDefault(person,0)+1);
        }

        for(String person : completion){
            hm.put(person,hm.get(person)-1);
        }

        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
                break;
            }
        }

        return answer;
    }
}
