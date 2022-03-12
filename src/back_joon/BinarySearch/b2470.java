package back_joon.BinarySearch;
import java.io.*;
import java.util.*;

public class b2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        int gap = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        int temp;
        int sum;
        while (i < j) {
            sum = arr[i] + arr[j];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                ans1 = arr[i];
                ans2 = arr[j];
            }
            if (sum > 0)
                j--;
            else
                i++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}
