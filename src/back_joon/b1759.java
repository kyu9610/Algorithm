package back_joon;
import java.util.*;

public class b1759 {
    public static int L,C;
    public static char[] password;
    public static char[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();
        password = new char[C];
        temp = new char[L];

        // 알파벳 입력받기.
        for(int i=0;i<C;i++){
            password[i] = sc.next().charAt(0);
        }

        // 배열 정렬.
        Arrays.sort(password);

        makeCode(0,0);
    }

    public static void makeCode(int x,int idx){
        if(idx == L){
            if(check()) {
                System.out.println(temp);
            }
            return;
        }

        for(int i=x; i<C; i++){
            temp[idx] = password[i];
            makeCode(i+1,idx+1);
        }
    }

    public static boolean check(){
        int mo = 0;
        int ja = 0;

        for(char x : temp){
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                mo++;
            }else{
                ja++;
            }
        }

        if(mo >= 1 && ja >= 2){
            return true;
        }
        return false;
    }
}
