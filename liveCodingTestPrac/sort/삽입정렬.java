
// 하나의 수를 픽하고 앞에 정렬되어 있는 데이터와 비교하여 자신의 위치에 삽입
// 배열의 현재 인덱스(1번부터) 앞에 있는 배열 탐색
// 자신보다 크다면 자리교체
// O(n^2)
private int[] insertSort(int[] arr) {
  int n = arr.length;

  for(int i = 1; i < n; i++) {
    int currIdx = i;
    int pastIdx = i-1;
    while(pastIdx >= 0 && curr < arr[pastIdx]) {
      int curr = arr[currIdx];
      arr[currIdx--] = arr[pastIdx];
      arr[pastIdx--] = curr;
    }
  }
}
