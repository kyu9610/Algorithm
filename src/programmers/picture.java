package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2017 카카오코드 본선 - 단체사진 찍기
public class picture {
    private static int answer = 0;
    private static String[] friends = {"A","C","F","J","M","N","R","T"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 조건의 개수 입력받기
        System.out.print("조건의 개수 : ");
        int n = Integer.parseInt(br.readLine());
        // 조건 입력받기
        System.out.print("조건 : ");
        st = new StringTokenizer(br.readLine());
        String[] data = new String[n];
        for(int i=0;i<n;i++){
            data[i] = st.nextToken();
        }

        solution(n,data);
    }

    public static int solution(int n,String[] data){
        boolean[] isVisited = new boolean[8];
        dfs("",isVisited,data);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(String names,boolean[] isVisited,String[] data){
        if(names.length() == 8){
            if(check(names,data)) answer++;
            return;
        }

        for(int i=0;i<8;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name,isVisited,data);
                isVisited[i] = false;
            }
        }
    }

    private static boolean check(String names,String[] datas){
        for(String data : datas){
            int position1 = names.indexOf(data.charAt(0));
            int position2 = names.indexOf(data.charAt(2));
            char op = data.charAt(3);
            int idx = data.charAt(4) -'0';
            switch(op){
                case '=':
                    if(!(Math.abs(position1-position2) == idx+1)) return false;
                    break;
                case '<':
                    if(!(Math.abs(position1-position2) < idx+1)) return false;
                    break;
                case '>':
                    if(!(Math.abs(position1-position2) > idx+1)) return false;
                    break;
            }
        }
        return true;
    }

}
