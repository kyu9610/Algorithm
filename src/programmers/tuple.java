package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tuple {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(solution(s));
    }
    public static ArrayList<Integer> solution(String s){
        ArrayList<Integer> answer = new ArrayList<>();

        // 첫번째 {{ 를 삭제
        s = s.substring(2,s.length());
        // 마지막 }} 를 삭제하고 "-"로 나눠준다.
        s = s.substring(0,s.length()-2).replace("},{","-");
        String[] str = s.split("-");

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        for(String x : str){
            String[] temp = x.split(",");
            for(int i=0;i<temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
        }
        return answer;
    }
}
