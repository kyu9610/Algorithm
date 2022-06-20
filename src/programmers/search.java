package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class search {
    static HashMap<String,ArrayList<Integer>> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for(String s : info){
            String[] arr = s.split(" ");
            dfs(arr,"",0);
        }

        for(String key : map.keySet()) Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }

    public static void dfs(String[] arr, String str, int cnt){
        if(cnt == 4){
            if(!map.containsKey(str)){
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        dfs(arr,str+"-",cnt+1);
        dfs(arr,str+arr[cnt],cnt+1);
    }

    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }
}
