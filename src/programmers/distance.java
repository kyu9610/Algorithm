package programmers;
import java.util.*;

public class distance {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0;i<places.length;i++){
            String[] p = places[i];

            boolean fine = true;
            for(int r=0;r<5 && fine;r++){
                for(int c=0;c<5 && fine;c++){
                    if(p[r].charAt(c) == 'P'){
                        if(!bfs(r,c,p)){
                            fine = false;
                        }
                    }
                }
            }
            answer[i] = fine ? 1 : 0;

        }

        return answer;
    }

    private static boolean bfs(int r,int c, String[] p){
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r,c});

        while(!queue.isEmpty()){
            int[] q = queue.poll();

            for(int i=0;i<4;i++){
                int nr = q[0] + dx[i];
                int nc = q[1] + dy[i];

                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc==c)){
                    continue;
                }

                int d = Math.abs(nr-r) + Math.abs(nc-c);

                if(p[nr].charAt(nc) == 'P' && d <= 2){
                    return false;
                }else if(p[nr].charAt(nc) == '0' && d < 2){
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        return true;
    }
}
