package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class menu {
    static HashMap<String,Integer> map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력받기
        System.out.println("orders number : ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("input orders");
        String[] orders = new String[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            orders[i] = st.nextToken();
        }

        System.out.println("course number : ");
        int m = Integer.parseInt(br.readLine());

        System.out.println("input course");
        int[] course = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            course[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(orders,course));
    }

    public static ArrayList<String> solution(String[] orders,int[] course){
        ArrayList<String> answer = new ArrayList<>();

        // 정렬하기
        for(int i=0;i<orders.length;i++){
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }

        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for(int j=0;j<orders.length;j++){
                StringBuilder sb = new StringBuilder();

                if(course[i] <= orders[j].length()){
                    combination(orders[j],sb,0,0,course[i]);
                }
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(max >= 2 && entry.getValue() == max){
                    answer.add(entry.getKey());
                }
            }

        }
        Collections.sort(answer);

        return answer;
    }

    public static void combination(String order,StringBuilder sb,int idx,int cnt,int n){
        if(cnt == n){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + 1);
            return;
        }

        for(int i=idx;i<order.length();i++){
            sb.append(order.charAt(i));
            combination(order,sb,i+1,cnt+1,n);
            sb.delete(cnt,cnt+1);
        }
    }
}
