// 목적지를 기준으로 전체 순회
// 0번인덱스 인접한 인덱스와 비교 후 작은 수가 뒤에 있으면 자리 교환
// 배열의 인덱스 모두 탐색
// 큰 수가 뒤부터 정렬되기 때문에 탐색범위는 점차 1씩 감소
// O(n^2)
private int[] BubbleSort(int[] arr) {
  int n = arr.length;

  for(int i = n-1; i > 0; i--) {
    for(int j = 0; j < i; j++) {
      int curr = arr[j];
      int next = arr[j+1];
      
      if(curr > next) swap(arr, curr, next);
      
    }
  }
  
}

private void swap(int[] arr, int a, int b) {
  int temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
}
