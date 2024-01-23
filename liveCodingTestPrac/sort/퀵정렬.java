// 병합정렬처럼 분할정복법 활용, pivot 활용, 재귀
// o(nlogn)
/**
* 1) 배열에서 하나의 요소를 선택하여 이를 pivot으로 지정 (보통 처음, 중간, 끝 선택)
* 2) pivot을 기준으로 배열을 두 그룹으로 분리
* 3) 분리된 그룹의 왼쪽은 피봇보다 작은 수, 오른쪽은 피봇보다 큰 수
* 4) 정렬 후 merge
*/
public class QuickSort {
    private static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end)/2];
        while(start <= end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return;
    }
    public static void main(String[] args) {
        int[] arr= {7,4,2,8,3,5,1,6,10,9};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+",");
        }
    }
}
