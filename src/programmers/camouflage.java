package programmers;
import java.util.*;
public class camouflage {
    public static void main(String[] args) throws Exception{
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        solution(clothes);

        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        solution(clothes2);
    }

    private static int solution(String[][] clothes){
        HashMap<String,Integer> hm = new HashMap<>();
        int answer = 1;
        for(int i=0;i<clothes.length;i++){
            String key = clothes[i][1];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }

        for(String key : hm.keySet()) {
            answer *= hm.get(key)+1;
        }

        System.out.println(answer-1);
        return answer-1;
    }
}
