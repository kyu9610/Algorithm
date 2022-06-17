package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class craneGame {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(board,moves));
    }

    public static int solution(int[][] board,int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int move : moves){
            for(int j=0;j<board[move-1].length;j++){
                if(board[j][move-1] != 0){
                    if(stack.peek() == board[j][move-1]){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(board[j][move-1]);
                    }
                    board[j][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
