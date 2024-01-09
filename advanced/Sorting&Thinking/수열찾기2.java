import java.util.Arrays;
import java.util.HashMap;

// 가장 작은 수 무조건 수열 - 갖고 있는 걸 모두 두 배 했기 때문
// 본인과 본인의 두배 cnt를 0으로 만드는 방식
public class 수열찾기2 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        // 1. 수의 중복 HashMap 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. nums 오름차순 정렬
        Arrays.sort(nums);
        // 3. nums 순회하며 체크
        int idx = 0;
        for(int n : nums) {
            if(map.get(n)==0) continue;
            map.put(n, map.get(n)-1);
            map.put(n*2, map.get(n*2)-1);
            answer[idx++] = n;
        }

        return answer;
    }

    public static void main(String[] args){
        수열찾기2 T = new 수열찾기2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
