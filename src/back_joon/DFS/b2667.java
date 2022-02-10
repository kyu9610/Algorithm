package back_joon.DFS;
import java.util.*;

public class b2667 {
    static int N;
    static int[][] map;
    static int[][] check;
    static int cnt;
    static int home;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        check = new int[N][N];
        cnt = 0;

        for(int i=0;i<N;i++){
            String temp = sc.next();
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                home = 0;
                if(map[i][j] == 1 && check[i][j] == 0){
                    cnt++;
                    home++;
                    dfs(i,j);
                }

                if(home != 0){
                    arrayList.add(home);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(arrayList);
        for(int i=0; i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }

    public static void dfs(int x,int y){
        check[x][y] = 1; // 확인여부

        if(y < map[x].length-1 && map[x][y+1] == 1 && check[x][y+1] == 0){
            dfs(x,y+1);
            home++;
        }

        if(x < map.length-1 && map[x+1][y] == 1 && check[x+1][y] == 0){
            dfs(x+1,y);
            home++;
        }

        if(y > 0 && map[x][y-1] == 1 && check[x][y-1] == 0){
            dfs(x,y-1);
            home++;
        }
        if(x > 0 && map[x-1][y] == 1 && check[x-1][y] == 0){
            dfs(x-1,y);
            home++;
        }
    }
}
