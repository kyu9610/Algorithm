package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class budget {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 예산의 갯수
        int[] d = new int[n]; // 예산 배열 생성

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            d[i] = Integer.parseInt(st.nextToken());
        }

        int budget = Integer.parseInt(br.readLine()); // 예산 받아오기

        System.out.println(solution(d,budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            budget = budget - d[i];
            if(budget < 0){
                break;
            }
            answer++;
        }
        return answer;
    }
}
