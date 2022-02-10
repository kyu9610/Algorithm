package back_joon;
import java.util.*;

public class b1697 {
    static int N,K;
    static int check[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        N = sc.nextInt();
        K = sc.nextInt();
        check = new int[100001];

        if(N==K){
            System.out.println("0");
        }else{
            bfs(N);
        }
    }

    public static void bfs(int num){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);
        check[num] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0;i<3;i++){
                int next;

                if(i==0){
                    next = cur + 1;
                }else if (i==1){
                    next = cur - 1;
                }else{
                    next = cur * 2;
                }

                if(next == K){
                    System.out.println(check[cur]);
                    return;
                }

                if(next < 0 || next >= check.length || check[next] != 0 ){
                    continue;
                }

                q.add(next);
                check[next] = check[cur]+1;
            }
        }
    }
}
