
import java.util.HashMap;

// 데이터가 200,000 개 이하이므로, O(N)으로 해결
// nums 데이터에 양수만 있었다면, 투 포인터 알고리즘으로 문제 해결
// 사실 뭐가 됐든 이중반복문으로 해결할 수 있겠지만, 대부분 데이터가 100,000을 넘어감
// 따라서 O(N) 이하로 해결
public class 음수가있는부분수열 {

    public int solution(int[] nums, int m) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumCnt = new HashMap<>();
        sumCnt.put(0, 1);

        // 현재 인덱스의 숫자를 끝자리 수열로 하여 기준으로 지정
        for (int i = 0; i < nums.length; i++) {
            // sum 누적
            sum += nums[i];
            // 현재 sum-m 이 음수가 아니면
            int remain = sum - m;

            // sum-m 값이 HashMap에 있는지 체크
            if (sumCnt.containsKey(remain)) {
                // 있다면 sum-m의 value를 answer에 더함
                answer += sumCnt.get(remain);
            }

            // hashmap sum-m을 키로하여 value에 +1
            sumCnt.put(sum, sumCnt.getOrDefault(sum, 0) + 1);
        }


        return answer;
    }

    public static void main(String[] args) {
        음수가있는부분수열 T = new 음수가있는부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
