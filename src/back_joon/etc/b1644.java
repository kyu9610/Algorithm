package back_joon.etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b1644 {

    static boolean prime[] = new boolean[4000001];
    static List<Integer> prime_list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        prime();
        int size = prime_list.size();

        int count = 0;
        int first = 0,second = 0;

        while(true){
            int sum = sum(first,second);
            if(sum == n){
                count += 1;
                second += 1;
            }else if(sum < n){
                second += 1;
            }else{
                first += 1;
            }

            if(second == size || first == size || first > second){
                break;
            }
        }

        System.out.println(count);
    }

    static void prime() {

        int n = 4000000;
        // 소수가 아니면 true
        prime[0] = prime[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 0; i < 4000001; i++) {
            if (!prime[i]) {
                prime_list.add(i);
            }
        }
    }

    static int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += prime_list.get(i);
        }
        return sum;
    }
}
