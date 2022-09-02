package programmers;

public class country124 {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        String[] numbers = {"4","1","2"};
        String answer = "";

        int num = n;

        while(num > 0){
            int remain = num % 3;
            num /= 3;

            if(remain == 0) num--;

            answer = numbers[remain] + answer;
        }

        return answer;
    }
}
