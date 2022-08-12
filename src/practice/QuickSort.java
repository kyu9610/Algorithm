package practice;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 17, 6, 3, 83, 4, 5};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int low,int high){
        if(low >= high) return;

        int pivot = partition(arr,low,high);

        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }

    private static int partition(int[] arr,int left, int right){
        int low = left;
        int high = right;
        int pivot = arr[right];

        while(low < high){
            while(arr[low] <= pivot && low < high){
                low++;
            }
            while(arr[high] >= pivot && low < high){
                high--;
            }

            swap(arr,low,high);
        }

        swap(arr,right,high);
        System.out.println("a" + Arrays.toString(arr));
        return high;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
