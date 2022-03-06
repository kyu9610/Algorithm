package back_joon.Data_Structures;
import java.util.*;

public class b10868 {
    static int[] input;
    static int[] minTree;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        input = new int[N+1];

        for(int i=1;i<=N;i++){
            input[i] = sc.nextInt();
        }

        minTree = new int[N*4];

        // minTree 생성
        minInit(1,N,1);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            int left = sc.nextInt();
            int right = sc.nextInt();

            sb.append(minFind(1,N,1,left,right)).append('\n');
        }

        System.out.println(sb);
    }

    public static int minInit(int start,int end,int node){
        if(start == end){
            return minTree[node] = input[start];
        }

        int mid = (start+end) / 2;
        return minTree[node] = Math.min(minInit(start,mid,node*2),minInit(mid+1,end,node*2+1));
    }

    public static int minFind(int start,int end,int node,int left,int right){
        if(start > right || end < left){
            return Integer.MAX_VALUE;
        }

        if(left <= start && end <= right){
            return minTree[node];
        }

        int mid = (start+end) / 2;
        return Math.min(minFind(start,mid,node*2,left,right),minFind(mid+1,end,node*2+1,left,right));
    }
}
