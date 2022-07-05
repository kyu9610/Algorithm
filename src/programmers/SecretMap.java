package programmers;

public class SecretMap {
    public static void main(String[] args) {

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] temp = new String[2][n];

        for(int i=0;i<arr1.length;i++){
            temp[0][i] = binaryNumber(arr1[i],n);
            temp[1][i] = binaryNumber(arr2[i],n);
        }

        for(int i=0;i<n;i++){
            answer[i] = "";
            for(int j=0;j<n;j++){
                if(temp[0][i].charAt(j) == '1' || temp[1][i].charAt(j) == '1'){
                    answer[i] += "#";
                }else{
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }

    private static String binaryNumber(int number,int n){
        StringBuilder sb = new StringBuilder();
        while(number > 0){
            sb.insert(0,number%2);
            number = number / 2;
        }

        while(sb.length() < n){
            sb.insert(0,0);
        }

        return sb.toString();
    }
}
