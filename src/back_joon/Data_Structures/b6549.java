package back_joon.Data_Structures;
import java.util.*;

public class b6549 {

    static int[] arr;
    static int[] tree;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            int N = sc.nextInt();

            if(N==0){
                break;
            }

            arr = new int[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = sc.nextInt();
            }

            tree = new int[N*4];
            init(1,N,1);

            sb.append(getMax(1,N,N) + "\n");
        }

        System.out.println(sb);
    }

    public static void init(int start,int end,int node){
        if(start == end){
            tree[node] = start;
        }else{
            int mid = (start+end) / 2;
            init(start,mid,node*2);
            init(mid+1,end,node*2+1);

            if(arr[tree[node*2]] <= arr[tree[node*2+1]]){
                tree[node] = tree[node*2];
            }else{
                tree[node] = tree[node*2+1];
            }
        }
    }

    public static long getMax(int start,int end,int N){
        int m = query(1,N,1,start,end);

        long area = (end - start + 1) * (long)arr[m];

        if(start <= m-1){
            long tmp = getMax(start,m-1,N);

            area = Math.max(area,tmp);
        }

        if(m+1 <= end){
            long tmp = getMax(m+1,end,N);

            area = Math.max(area,tmp);
        }

        return area;
    }

    public static int query(int start,int end,int node,int left,int right){
        if(right < start || left > end){
            return -1;
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;
        int m1 = query(start,mid,node*2,left,right);
        int m2 = query(mid+1,end,node*2+1,left,right);

        if(m1 == -1){
            return m2;
        }else if(m2 == -1){
            return m1;
        }else{
            if(arr[m1] <= arr[m2]){
                return m1;
            }else{
                return m2;
            }
        }
    }
}
