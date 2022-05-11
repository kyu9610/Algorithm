package back_joon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1325 {

    static int[] comp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        comp = new int[n+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            boolean[] visited = new boolean[n+1];
            dfs(i,visited,list);
        }

        for(int i=1;i<=n;i++){
            max = Math.max(max,comp[i]);
        }

        for(int i=1;i<=n;i++){
            if(comp[i] == max){
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int start,boolean[] visited,ArrayList<Integer>[] list){
        visited[start] = true;

        for(int node : list[start]){
            if(!visited[node]){
                comp[node]++;
                dfs(node,visited,list);
            }
        }
    }
}
