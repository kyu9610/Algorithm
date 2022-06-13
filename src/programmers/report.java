package programmers;
import java.util.*;

public class report {
    class Solution{
        public int[] solution(String[] id_list,String[] report,int k){
            int[] answer = new int[id_list.length];
            Map<String,HashSet<String>> map = new HashMap<>();
            Map<String,Integer> idxMap = new HashMap<>();

            for(int i=0;i<id_list.length;i++){
                String name = id_list[i];
                map.put(name,new HashSet<>());
                idxMap.put(name,i);
            }

            for(String s : report){
                String[] str = s.split(" ");
                String to = str[0];
                String from = str[1];
                map.get(to).add(from);
            }

            for(int i=0;i<id_list.length;i++){
                HashSet<String> send = map.get(id_list[i]);
                if(send.size() >= k){
                    for(String name : send){
                        answer[idxMap.get(name)]++;
                    }
                }
            }
            return answer;
        }
    }
}
