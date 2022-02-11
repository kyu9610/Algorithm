package back_joon.Data_Structures;
import java.util.*;

public class b5430{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            String str = scan.next();
            int num = scan.nextInt();

            String x = scan.next();
            String x_sub[] = x.substring(1, x.length() - 1).split(",");
            Deque<Integer> queue = new LinkedList<>();
            for(int i = 0; i < x_sub.length; i++) {
                if(!x_sub[i].equals(""))
                    queue.offer(Integer.valueOf(x_sub[i]));
            }
            System.out.println(ac(queue, str));
        }
    }
    public static String ac(Deque<Integer> queue, String str){
        boolean reverse = false;
        for (char s : str.toCharArray()) {
            if (s == 'R') {
                reverse = !reverse;
            }
            else{
                if(queue.size() == 0){
                    return "error";
                }
                if (reverse) {
                    queue.removeLast();
                }
                else
                    queue.removeFirst();
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while(!queue.isEmpty()){
            if(reverse)
                sb.append(queue.removeLast());
            else
                sb.append(queue.removeFirst());
            if(queue.size() != 0)
                sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }
}
