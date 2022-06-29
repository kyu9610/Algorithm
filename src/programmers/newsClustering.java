package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class newsClustering {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(solution(str1,str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int inter = 0;
        int union = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            String key = str1.substring(i, i + 2);
            if ('A' > key.charAt(0) || key.charAt(0) > 'Z' || 'A' > key.charAt(1) || key.charAt(1) > 'Z') {
                continue;
            }
            hm.put(key, hm.getOrDefault(key, 0) + 1);
            union++;
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String key = str2.substring(i, i + 2);
            if ('A' > key.charAt(0) || key.charAt(0) > 'Z' || 'A' > key.charAt(1) || key.charAt(1) > 'Z') {
                continue;
            }
            if (hm.containsKey(key) && hm.get(key) >= 1) {
                inter++;
                hm.put(key, hm.get(key) - 1);
            } else {
                hm.put(key, hm.getOrDefault(key, 0) - 1);
                union++;
            }
        }

        System.out.println(inter + " " + union);
        if (union == 0) {
            answer = 65536;
        } else {
            answer = (inter * 65536 / union);
        }

        return answer;
    }
}
