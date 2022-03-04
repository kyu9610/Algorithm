package back_joon.Data_Structures;
import java.util.*;

public class b2042 {

    static long[] input,tree;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        input = new long[N+1];
        tree = new long[N*4];

        for(int i=1;i<=N;i++){
            input[i] = sc.nextLong();
        }

        init(1,N,1); // segment tree 생성.

        for(int i=0;i<M+K;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 1){
                long c = sc.nextLong();
                long diff = c - input[b];
                input[b] = c;
                update(1,N,1,b,diff);
            }else{
                int c = sc.nextInt();
                System.out.println(sum(1,N,1,b,c));
            }
        }


    }

    public static long init(int start,int end,int node){
        if(start == end){
            return tree[node] = input[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start,mid,(node*2)) + init(mid+1,end,(node*2)+1);
    }

    public static long sum(int start,int end,int node,int left,int right){
        if(left > end || right < start){
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start,mid,node*2,left,right) + sum(mid+1,end,(node*2)+1,left,right);
    }

    public static void update(int start,int end,int node,int index,long diff){
        if(index < start || index > end){
            return;
        }
        tree[node] += diff;
        if(start == end){
            return;
        }
        int mid = (start + end) / 2;
        update(start,mid,node*2,index,diff);
        update(mid+1,end,node*2+1,index,diff);
    }
}
