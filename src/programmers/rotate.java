package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class rotate {
    private static int[][] map;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        System.out.println("query 개수 : ");
        int count = Integer.parseInt(br.readLine());
        int[][] queries = new int[count][4];

        for(int i=0;i<count;i++){
            System.out.println("query : ");
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            queries[i][2] = Integer.parseInt(st.nextToken());
            queries[i][3] = Integer.parseInt(st.nextToken());
        }

        solution(rows,cols,queries);
    }

    public static int[] solution(int rows,int colums,int[][] queries){
        int[] answer = new int[queries.length];
        map = new int[rows][colums];
        int value = 1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<colums;j++){
                map[i][j] = value++;
            }
        }

        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            min = Integer.MAX_VALUE;
            answer[i] = rotation(query);
        }

        for(int i=0;i< answer.length;i++){
            System.out.println(answer[i] + " ");
        }

        return answer;
    }

    public static int rotation(int[] query){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = map[x1][y1];
        int idx = 0;

        int curX = x1;
        int curY = y1;

        while(idx < 4){
            int nextX = curX + dx[idx];
            int nextY = curY + dy[idx];

            if(nextX < x1 || nextY < y1 || nextX > x2 || nextY > y2){
                idx++;
            }else{
                map[curX][curY] = map[nextX][nextY];
                min = Math.min(min,map[curX][curY]);
                curX = nextX;
                curY = nextY;
            }
        }
        map[curX][curY+1] = temp;
        min = Math.min(min,map[curX][curY+1]);

        return min;
    }
}
