package programmers;

public class minRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        solution(sizes);
    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        int max_row = 0;
        int max_col = 0;

        for(int i=0;i<sizes.length;i++){
            int row = Math.max(sizes[i][0],sizes[i][1]);
            int col = Math.min(sizes[i][0],sizes[i][1]);
            max_row = Math.max(max_row,row);
            max_col = Math.max(max_col,col);
        }

        answer = max_row * max_col;
        System.out.println(answer);
        return answer;
    }
}
