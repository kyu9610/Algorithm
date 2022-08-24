package programmers;

import java.util.HashMap;
import java.util.Map;

public class MBTI {
    public static void main(String[] args) {
        solution(new String[]{"AN","CF","MJ","RT","NA"},new int[]{5,3,2,7,5});
        solution(new String[]{"TR","RT","TR"},new int[]{7,1,3});
    }

    private static String solution(String[] survey, int[] choices){
        char[] arr = new char[]{'R','T','C','F','J','M','A','N'};
        Map<Character,Integer> map = new HashMap<>();
        // 초기화
        for(int idx=0;idx<8;idx++){
            map.put(arr[idx],0);
        }

        StringBuilder sb = new StringBuilder();

        for(int idx=0;idx< survey.length;idx++){
            char type1 = survey[idx].charAt(0);
            char type2 = survey[idx].charAt(1);
            int choice = choices[idx]-4;

            if(choice < 0){
                map.put(type1,map.getOrDefault(type1,0) - choice);
            }else{
                map.put(type2,map.getOrDefault(type2,0) + choice);
            }
        }

        for(int idx=0;idx<4;idx++){
            int value1 = map.get(arr[idx * 2]);
            int value2 = map.get(arr[idx * 2 + 1]);

            if(value1 >= value2){
                sb.append(arr[idx*2]);
            }else{
                sb.append(arr[idx*2+1]);
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
