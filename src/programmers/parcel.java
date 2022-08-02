package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class parcel {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] order = new int[n];
        for(int i=0;i<n;i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(order));
    }

    private static int solution(int[] order){
        Stack<Integer> assist = new Stack<>();
        Stack<Integer> truck = new Stack<>();
        int left = 0;
        for(int i=1;i<=order.length;i++){
            assist.push(i);
            while(!assist.empty() && left < order.length && order[left] == assist.peek()){
                truck.push(assist.pop());
                left++;
            }
        }
        return truck.size();
    }
}
