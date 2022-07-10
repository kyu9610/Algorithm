package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 2018 카카오 블라인드 - [1차]캐시
public class cache {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cacheSize,cityCount;
        String[] cities;
        System.out.print("input cacheSize : ");
        cacheSize = Integer.parseInt(br.readLine());

        System.out.print("input city count : ");
        cityCount = Integer.parseInt(br.readLine());

        cities = new String[cityCount];
        System.out.print("input cities : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<cityCount;i++){
            cities[i] = st.nextToken();
        }

        System.out.println(solution(cacheSize,cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        // 알고리즘 -> LRU, cache hit -> 1, cache miss -> 5
        if(cacheSize == 0) return cities.length * 5;
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i=0;i<cities.length;i++){
            String s = cities[i].toUpperCase();
            if(cache.remove(s)){
                answer += 1;
                cache.add(s);
            }else{
                answer += 5;
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                cache.add(s);
            }
        }
        return answer;
    }
}
