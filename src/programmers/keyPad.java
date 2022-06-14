package programmers;

public class keyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                left = number;
            }else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                right = number;
            }else{
                if(number == 0) number = 11;
                int distL = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int distR = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;
                if(distL > distR){
                    answer += "R";
                    right = number;
                }else if(distL < distR){
                    answer += "L";
                    left = number;
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        right = number;
                    }else{
                        answer += "L";
                        left = number;
                    }
                }
            }
        }
        return answer;
    }
}
