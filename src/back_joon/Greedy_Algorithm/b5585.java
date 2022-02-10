package back_joon.Greedy_Algorithm;
import java.util.Scanner;

public class b5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성.
        int price; // 타로가 지불해야할 금액.
        int changes; // 잔 돈.
        int count = 0; // 잔 돈의 갯수

        System.out.println("지불해야할 금액을 입력하세요 : "); // 금액은 1~999 사이의 정수이다.
        price = sc.nextInt(); // 입력을 받아 price 변수에 저장.

        changes = 1000 - price; // 1000엔 지폐를 지불하였고 가격을 뺀 돈을 잔 돈으로 받는다.

        // 잔 돈으로는 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 있다.
        if(changes / 500 > 0){
            count = count + (changes / 500); // 500엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 500; // 잔돈 - (500엔 갯수)
        }

        if(changes / 100 > 0){
            count = count + (changes / 100); // 100엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 100; // 잔돈 - (100엔 갯수)
        }

        if(changes / 50 > 0){
            count = count + (changes / 50); // 50엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 50; // 잔돈 - (50엔 갯수)
        }

        if(changes / 10 > 0){
            count = count + (changes / 10); // 10엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 10; // 잔돈 - (10엔 갯수)
        }

        if(changes / 5 > 0){
            count = count + (changes / 5); // 5엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 5; // 잔돈 - (5엔 갯수)
        }

        if(changes / 1 > 0){
            count = count + (changes / 1); // 1엔 갯수만큼 잔 돈의 갯수 추가
            changes = changes % 1; // 잔돈 - (1엔 갯수)
        }

        System.out.println("count = " + count);
    }
}
