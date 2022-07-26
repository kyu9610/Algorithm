package practice;

// 10번동안 1~10까지 랜덤한 숫자를 출력하여 중복된 숫자가 있을경우 true,false 리턴
public class random {
    public static void main(String[] args) {
        int[] number = new int[10];
        boolean isDuplicate = false;

        for(int i=0;i<10;i++){
            number[i] = (int)(Math.random()*10)+1;
            System.out.print(number[i] + " ");
        }

        for(int i=0;i<10;i++){
            int duplicate = number[i];
            for(int j=i+1;j<10;j++){
                if(duplicate == number[j]){
                    isDuplicate = true;
                    break;
                }
            }
        }

        System.out.println(isDuplicate);
    }
}
