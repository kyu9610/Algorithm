package back_joon;
import java.util.*;

public class b1012 {
    static int cab[][];
    static int check[][];
    static int cnt;

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for(int i=0;i<T;i++){
            int M = sc.nextInt(); // 가로길이
            int N = sc.nextInt(); // 세로길이
            int K = sc.nextInt(); // 배추의 심어진 개수

            // 배열 초기화
            cab = new int[N][M];
            check = new int[N][M];
            cnt = 0;

            // 배추 개수만큼 반복문, 배추를 심는다(1로 설정)
            for(int j=0;j<K;j++){
                int m = sc.nextInt();
                int n = sc.nextInt();
                cab[n][m] = 1;
            }

            // 배추 탐색
            for(int j=0;j<cab.length;j++){
                for(int k=0;k<cab[j].length;k++){
                    // 만약 배추가 심어져있고, 확인이 되어있지 않다면
                    if(cab[j][k] == 1 && check[j][k] == 0){
                        cnt++;
                        dfs(j,k);
                    }
                }
            }

            arrayList.add(cnt);
        }

        for(int i=0;i<T;i++){
            System.out.println(arrayList.get(i));
        }
    }

    // DFS 수행 메소드
    public static void dfs(int x,int y){
        check[x][y] = 1; // 방문여부 확인

        // 기준점의 동서남북을 확인한다
        if(y < cab[x].length-1 && cab[x][y+1] == 1 && check[x][y+1] == 0){
            dfs(x,y+1);
        }

        if(x < cab.length-1 && cab[x+1][y] == 1 && check[x+1][y] == 0){
            dfs(x+1,y);
        }

        if(y > 0 && cab[x][y-1] == 1 && check[x][y-1] == 0){
            dfs(x,y-1);
        }

        if(x > 0 && cab[x-1][y] == 1 && check[x-1][y] == 0){
            dfs(x-1,y);
        }
    }
}
