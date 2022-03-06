package back_joon.Data_Structures;
import java.util.*;

public class b11505 {

    static long[] input,tree;
    static int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        input = new long[N+1];
        for(int i=1;i<=N;i++){
            input[i] = sc.nextLong();
        }

        tree = new long[N*4];
        init(1,N,1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if(a==1){
                input[b] = c;
                update(1,N,1,b,c);
            }else if(a==2){
                sb.append(findMul(1,N,1,b,(int)c)).append('\n');
            }
        }

        System.out.println(sb);
    }


    public static long init(int start,int end,int node){
        if(start == end){
            return tree[node] = input[start];
        }

        int mid = (start+end) / 2;
        return tree[node] = (init(start,mid,node*2) * init(mid+1,end,node*2+1)) % MOD;
    }

    public static long update(int start,int end,int node,int index,long val){
        if(index < start || index > end){
            return tree[node];
        }

        if(start == end){
            return tree[node] = val;
        }

        int mid = (start+end) / 2;
        return tree[node] = (update(start,mid,node*2,index,val) * update(mid+1,end,node*2+1,index,val)) % MOD;
    }

    public static long findMul(int start,int end,int node,int left,int right){
        if(left > end || right < start){
            return 1;
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start+end) / 2;

        return (findMul(start,mid,node*2,left,right) * findMul(mid+1,end,node*2+1,left,right)) % MOD;
    }
}
