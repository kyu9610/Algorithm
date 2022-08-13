package back_joon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class b2644 {
    static int n,m;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        bfs(p1,p2);
    }

    private static void bfs(int x,int y){
        boolean isOk = false;
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(x,0));
        isVisited[x] = true;

        while(!q.isEmpty()){
            Person person = q.poll();
            int newX = person.x;
            if(newX == y){
                isOk = true;
                System.out.println(person.cnt);
                break;
            }
            for(int i=1; i<=n; i++){
                if(!isVisited[i] && map[newX][i] == 1){
                    isVisited[i] = true;
                    q.offer(new Person(i, person.cnt+1));
                }
            }
        }

        if(!isOk){
            System.out.println(-1);
        }
    }

    private static class Person{
        int x;
        int cnt;

        public Person(int x,int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
}
