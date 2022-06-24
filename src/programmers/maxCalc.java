package programmers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class maxCalc {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long maxValue = solution(br.readLine());
        System.out.println(maxValue);
    }

    public static long solution(String expression){
        long answer = 0;
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        String num = "";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                operators.add(expression.charAt(i));
                numbers.add(Long.valueOf(num));
                num = "";
            }else {
                num += expression.charAt(i);
            }
        }
        numbers.add(Long.valueOf(num));

        long[] result = new long[6];

        result[0] = operation(numbers,operators,'+','-','*');
        result[1] = operation(numbers,operators,'+','*','-');
        result[2] = operation(numbers,operators,'-','+','*');
        result[3] = operation(numbers,operators,'-','*','+');
        result[4] = operation(numbers,operators,'*','-','+');
        result[5] = operation(numbers,operators,'*','+','-');

        for(int i=0;i<result.length;i++){
            if(answer < Math.abs(result[i])){
                answer = Math.abs(result[i]);
            }
        }
        return answer;
    }

    public static long operation(ArrayList<Long> nums,ArrayList<Character> ops,char op1,char op2,char op3){
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        for(int i=0;i<nums.size();i++){
            numbers.add(nums.get(i));
        }

        for(int i=0;i<ops.size();i++){
            operators.add(ops.get(i));
        }

        calc(numbers,operators,op1);
        calc(numbers,operators,op2);
        calc(numbers,operators,op3);

        return numbers.get(0);
    }

    public static void calc(ArrayList<Long> numbers,ArrayList<Character> ops,char op){
        for(int i=0;i<ops.size();i++){
            if(ops.get(i) == op){
                long num1 = numbers.get(i);
                long num2 = numbers.get(i+1);
                long result = cal(num1,num2,op);
                numbers.remove(i);
                numbers.remove(i);
                numbers.add(i,result);
                ops.remove(i);
                i--;
            }
        }
    }

    public static long cal(long a,long b,char op){
        if(op == '+'){
            return a+b;
        }else if(op == '-'){
            return a-b;
        }else{
            return a*b;
        }
    }
}
