package back_joon.etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b11005 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int not = Integer.parseInt(st.nextToken());

        List<Character> list = new ArrayList<>();
        while(number>0){
            if(number % not < 10){
                list.add((char)(number%not+'0'));
            }else{
                list.add((char)(number%not-10+'A'));
            }
            number /= not;
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
        }
    }
}
