/**
* 1) 배열의 인덱스만큼 순회한다.
* 2) 주어진 배열에서 현재 인덱스부터 마지막 인덱스까지 한번 더 순회하며, 최솟값을 찾는다.
* 3) 찾은 값을 현재 인덱스에 넣는다.
* 4) 마지막인덱스는 자동 정렬이므로 탐색하지 않는다.
* 시간복잡도 O(n^2)
*/
int[] selectSort(int arr[]) {
  int n = arr.length;
  for(int i = 0; i < n-1; i++) {
    int min = Integer.MIN_VALUE;
    int findIdx = 0;
    // 현재 인덱스부터 마지막 인덱스까지 탐색
    for(int j = i; j < n; j++) {
      int curr = arr[j];
      if(min <= curr) continue;
      min = curr;
      findIdx = j;
    }

    // 자리교체
    int temp = arr[0];
    arr[0] = min;
    arr[findIdx] = temp;
  }
  return answer;
}
