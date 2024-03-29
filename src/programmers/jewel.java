package programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class jewel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] gems = new String[n];
        for(int i=0;i<n;i++){
            gems[i] = st.nextToken();
        }
    }

    private static int[] solution(String[] gems){
        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        HashMap<String,Integer> hm = new HashMap<>();
        int start = 0;
        int end = Integer.MAX_VALUE;

        for(String s : gems){
            hs.add(s);
        }
        int startPoint = 0;
        for(int i=0;i<gems.length;i++){
            hm.put(gems[i], hm.getOrDefault(gems[i],0)+1);
            q.add(gems[i]);

            while(true){
                String temp = q.peek();
                if(hm.get(temp) > 1){
                    q.poll();
                    start++;
                    hm.put(temp,hm.get(temp)-1);
                }else{
                    break;
                }
            }
            if(hm.size() == hs.size() && end > q.size()){
                end = q.size();
                startPoint = start;
            }
        }
        return new int[]{startPoint+1, startPoint+end};
    }
}
