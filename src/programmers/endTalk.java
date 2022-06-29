package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class endTalk {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("인원수 , 글자 갯수 : ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());;
        int count = Integer.parseInt(st.nextToken());

        String[] words = new String[count];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<count;i++){
            words[i] = st.nextToken();
        }

        solution(n,words);
    }

    public static int[] solution(int n, String[] words){
        int[] answer = new int[2];
        char end = words[0].charAt(words[0].length()-1); // 맨 마지막 단어
        char start; // 시작 단어
        HashSet<String> set = new HashSet<>(); // 중복 포함여부 확인을 위한 set 생성
        set.add(words[0]);

        for(int i=1;i<words.length;i++){
            start = words[i].charAt(0);
            set.add(words[i]);
            if(end != start || set.size() != i+1){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
            end = words[i].charAt(words[i].length()-1);
        }

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}
