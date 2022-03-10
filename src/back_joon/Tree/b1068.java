package back_joon.Tree;
import java.util.*;


public class b1068 {
    static int N;
    static List<Integer>[] list;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList[N];

        for(int i=0;i<N;i++){
            list[i] = new ArrayList<>();
        }

        int root = -1;
        for(int i=0;i<N;i++){
            int num = sc.nextInt();
            if(num == -1){
                root = i;
                continue;
            }
            list[num].add(i);
        }

        int remove = sc.nextInt();

        removeNode(remove);
        if(remove == root){
            System.out.println(0);
        }else{
            System.out.println(findleaf(root));
        }
    }

    public static void removeNode(int node){
        if(list[node].size() > 0){
            int size = list[node].size();
            while(size > 0){
                int child = list[node].get(--size);
                removeNode(child);
            }
        }

        for(int i=0;i<N;i++){
            if(list[i].contains(node)){
                for(int j=0;j<list[i].size();j++){
                    if(list[i].get(j) == node){
                        list[i].remove(j);
                    }
                }
            }
        }
    }

    public static int findleaf(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int count = 0;

        while(!q.isEmpty()){
            int pos = q.poll();
            if(list[pos].size() == 0){
                count++;
                continue;
            }

            for(int next : list[pos]){
                q.add(next);
            }
        }
        return count;
    }
}
