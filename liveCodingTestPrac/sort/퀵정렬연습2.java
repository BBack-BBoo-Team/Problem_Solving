package codingtest;

import java.util.Arrays;

public class QuickSortPractice2 {

    public static void main(String[] args) {
        QuickSortPractice2 test = new QuickSortPractice2();
        int[] arr = new int[]{1,30,15,5,2,4,7,66,3,10};
        test.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int left, int right) {

        int part = partition(arr, left, right);
        if(left < part-1) quickSort(arr, left, part-1);
        if(right > part) quickSort(arr, part, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while(left <= right) {
            while(arr[left]<pivot) left++;
            while(arr[right]>pivot) right--;
            if(left<=right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
