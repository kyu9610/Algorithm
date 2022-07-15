package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

// 2018 카카오 블라인드 - [3차]압축
public class compress {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("input message : ");
        String msg = br.readLine();

        solution(msg);
    }

    private static ArrayList<Integer> solution(String msg){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> dic = new HashMap<>();
        // 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        char ch = 'A';
        for(int i=1;i<27;i++){
            dic.put(ch+"",i);
            ch += 1; // ch를 하나씩 증가시키며 'A' ~ 'Z' 를 넣어준다.
        }
        int dicIdx = 27;
        boolean isEnd = false;
        for(int idx=0;idx<msg.length();idx++){
            String word = msg.charAt(idx)+"";

            // 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            while(dic.containsKey(word)){
                idx++;
                if(idx == msg.length()){
                    isEnd = true;
                    break;
                }
                word += msg.charAt(idx);
            }

            if(isEnd){
                answer.add(dic.get(word));
                break;
            }
            // w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
            // 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
            answer.add(dic.get(word.substring(0,word.length()-1)));
            dic.put(word,dicIdx++);
            // 단계 2로 돌아간다.
            idx--;
        }

        // 출력
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i) + " ");
        }
        return answer;
    }
}
