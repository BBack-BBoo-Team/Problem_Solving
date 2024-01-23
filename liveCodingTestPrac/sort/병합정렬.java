// 분할정복법(Divide-And-Conquer) - O(nlogn), 재귀알고리즘
// (겹치지 않는) 작은 단위로 쪼갠 후 문제 해결 후 결과를 병합하는 방식
// 1) 절반씩 쪼개면서 1개가 남을 때까지 분할
// 2) 모두 분할하면 분할한 좌우끼리 비교하여 정렬하면서 병합
private int[] mergeSort(int[] arr) {
  ArrayList<Integer> list = Arrays.stream(arr)
                                  .boxed()
                                  .collect(
                                    Collectiors.toCollection(ArrayList::new)
                                  );
  split(list);
}

private ArrayList<Integer> split(ArrayList<Integer> list) {
    if(list.size() == 1) return list;
    
    int mid = list.size()/2;
    ArrayList<Integer> left = split(new ArrayList<>(list.subList(0, mid)));
    ArrayList<Integer> right = split(new ArrayList<>(list.subList(mid, list.size())));
    return merge(left, right);
}

private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

    ArrayList<Integer> mergedList = new ArrayList<>();

    int leftIdx = 0;
    int rightIdx = 0;

    // 1) left 와 right 둘 다 각각의 인덱스에 값이 있을 때
    while(left.size() > leftIdx && right.size() > rightIdx) {
        if(left.get(leftIdx) < right.get(rightIdx)) {
            mergedList.add(left.get(leftIdx));
            leftIdx++;
        } else {
            mergedList.add(right.get(rightIdx));
            rightIdx++;
        }
    }

    // 2) left 만 남아있을 때
    while (left.size() > leftIdx) {
        mergedList.add(left.get(leftIdx));
        leftIdx++;
    }

    // 3) right 만 남아 있을 때
    while (right.size() > rightIdx) {
        mergedList.add(right.get(rightIdx));
        rightIdx++;
    }
    return mergedList;
}
