package programmers;

// 프로그래머스 - 후보키 (2019 카카오 블라인드)

import java.util.HashSet;

public class candidateKey {
    public static String[][] g_relation;
    public static HashSet<String> set;

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        solution(relation);
    }

    public static int solution(String[][] relation){
        g_relation = relation;
        set = new HashSet<>();
        for(int i=1;i<relation[0].length;i++){
            boolean[] visited = new boolean[relation[0].length];
            dfs(0,0,i,visited);
        }
        System.out.println(set.size());
        return set.size();
    }

    private static void dfs(int idx,int cnt,int depth,boolean[] visited){
        if(cnt == depth){
            String key = "";
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    key += i;
                }
            }

            if(isKey(key,visited)){
                set.add(key);
            }
            return;
        }

        if(idx >= visited.length) return;
        visited[idx] = true;
        dfs(idx+1,cnt+1,depth,visited);
        visited[idx] = false;
        dfs(idx+1,cnt,depth,visited);
    }

    private static boolean isKey(String key,boolean[] visited){
        // 최소성이 만족되는지 확인
        // cols 안에 set에 들어있는 `후보키가 가능한 colume들의 집합의 요소들`이 모두 포함되어있는지 확인
        for (String s : set) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if(!key.contains(s.charAt(i)+"")){
                    flag = false;
                }
            }

            if(flag){ // 모두 포함되어있으면
                return false;
            }
        }

        // 몇번 colume들을 확인해야하는지 처리
        // 예를 들어, cols가 24라면 (== 2, 4번 colume 집합이 후보키가 되는지 확인해야 한다면)
        // col_name[] = {2,4} 가 된다.
        HashSet<String> values = new HashSet<>();
        int[] col_name = new int[key.length()];
        int idx = 0;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]){
                col_name[idx++] = i;
            }
        }

        // 값의 중복이 있는지 확인. 중복된 값이 있다면 후보키로 사용될 수 없음
        String value = "";
        for (int i = 0; i < g_relation.length; i++) {
            value = "";
            for (int j = 0; j < col_name.length; j++) {
                value += g_relation[i][col_name[j]];
            }
            if(values.contains(value)){
                return false; // 중복이 없다면 false 리턴
            }else{
                values.add(value);
            }
        }
        return true;
    }
}
