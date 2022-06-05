package back_joon.Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 탑의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();
        for(int i=1;i<=n;i++){
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[1] >= top){
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(new int[] {i,top});
        }
//        int arr[] = new int[n+1]; // 탑의 높이를 받는 배열 생성
//        int ans[] = new int[n+1]; // 수신한 탑의 번호를 저장하는 배열 생성
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=1;i<=n;i++){
//            arr[i] = Integer.parseInt(st.nextToken()); // 탑의 높이를 받아 배열에 저장
//        }
//
//        for(int i=n;i>=0;i--){
//            for(int j=i-1;j>=0;j--){
//                if(arr[i] <= arr[j]){
//                    ans[i] = j;
//                    break;
//                }
//            }
//        }
//
//        for(int i=1;i<=n;i++){
//            System.out.print(ans[i] + " ");
//        }
    }
}
