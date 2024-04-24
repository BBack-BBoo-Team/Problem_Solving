// 분할정복알고리즘
// O(NlogN) - 피봇에 따라 최악엔 N^2 발생
public class 퀵정렬연습 {
  public static void main(String[] args) {
    int[] arr = {2,5,4,1,3};
    quickSort(arr, 0, arr.length-1);
    for(int i : arr) System.out.println(i + ",");
  }

  // 퀵정렬
  private static void quickSort(int[] arr, int left, int right) {
    int part = partition(arr, left, right);
    if(left < part-1) quickSort(arr, left, part-1);
    if(right > part) quickSort(arr, part, right);
  }
  
  // 분할
  // 피봇 설정(처음, 중간, 마지막 설정 가능)
  // left가 right를 넘어설 때까지 반복
  // 1) 배열의 left 인덱스 값이 피봇보다 작으면 left+1(우측으로 한칸 이동) 
  // ㄴ 위 과정을 arr[left] 값이 피봇 이상일 때까지 반복 진행
  // 2) 배열의 right 인덱스 값이 피봇보다 크면 right-1(좌측으로 한칸 이동)
  // ㄴ 위 과정을 arr[right] 값이 피봇 이하일 때까지 반복 진행
  // 3) left가 right 이하라면 arr[left]와 arr[right] 의 값 자리교체
  // ㄴ left+1, right-1
  // left가 right를 넘어섰다면 left 반환
  private static int partition(int[] arr, int left, int right) {
    int mid = (left+right)/2;
    int pivot = arr[mid];

    while(left<=right) {
      while(arr[left]<pivot) left++;
      while(arr[right]>pivot) right--;
      if(left<=right) {
        swap(arr,left,right);
        left++;
        right--;
      }
    }
    return left;
  }
  
  // 자리교체
  private static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
