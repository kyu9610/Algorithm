package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2018 카카오 블라인드 - [1차]프렌즈 4블록
public class friendsBlock {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("input m,n : ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.print("input board[] : ");
        String[] board = new String[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            board[i] = st.nextToken();
        }

        solution(m,n,board);
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0; // 정답 변수
        char[][] map = new char[m][n]; // board배열을 저장하는 2차원 배열 생성

        // 반복문을 이용하여 2차원배열에 주어진 배열을 넣는다.
        for(int i=0;i<m;i++){
            map[i] = board[i].toCharArray();
        }

        // 반복문을 통해 더 이상 지울 2x2 모양이 없고, 떨어질 블록이 없을 경우 멈춘다.
        while(true){
            int cnt = checkBlock(m,n,map); // 지울 2x2 모양 블록의 개수를 센다.
            if(cnt == 0) break; // 지울 블록이 없으면 반복문 break
            answer += cnt;

            dropBlock(m,n,map); // 2x2 모양 블록이 지워지면 블록을 떨어트린다.
        }

        System.out.println(answer);
        return answer;
    }

    public static int checkBlock(int m,int n,char[][] map){
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(map[i][j] == '.') continue; // '.' 일 경우 확인하지 않는다.
                checkFour(map,visited,i,j); // 반복문을 통해 2x2 블록이 4개가 붙어있는지확인
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]){
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }

    public static void checkFour(char[][] map,boolean[][] visited,int i,int j){
        char block = map[i][j];

        // 같은 문자인지 확인하고 아니면 함수를 return
        for(int r=i;r<i+2;r++){
            for(int c=j;c<j+2;c++){
                if(map[r][c] != block) return;
            }
        }

        // return 되지않는 다면 같은 문자인것으로 판단
        for(int r=i;r<i+2;r++){
            for(int c=j;c<j+2;c++){
                visited[r][c] = true;
            }
        }
    }

    public static void dropBlock(int m,int n,char[][] map){
        for(int c = 0 ; c < n ; c++) {
            for(int r = m - 1 ; r >= 0 ; r--) {
                if(map[r][c] == '.') {
                    for(int nr = r - 1 ; nr >= 0 ; nr--) {
                        if(map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
