// 직접 정렬 코드 구현 - quick sort
class Solution {
  public int solution(int []A, int []B) {
    int answer = 0;

    int totalIdx = A.length-1;

    quickSort(A, 0, totalIdx-1);
    quickSort(B, 0, totalIdx-1);
    
    for(int i = 0; i <= totalIdx; i++) {
        answer+= A[i] * B[totalIdx-i];
    }

    return answer;
  }

  // 피봇 활용
  public static void quickSort(int[] arr, int left, int right) {

    int i, j, pivot, tmp;

    if(left < right) {
      i = left;
      j = right;
      privot = arr[left];

      // 분할과정
      while(i < j) {
        while (arr[j] > pivot) j--;
        while (i < j && arr[i]<=pivot) i++;

        tmp = arr[i];
        arr[i] = pivot;

        // 정렬과정
        quickSort(arr, left, i-1);
        quickSort(arr, i+1, right);
      }
    }
  }
}
