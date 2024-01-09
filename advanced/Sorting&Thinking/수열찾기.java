import java.util.Arrays;
import java.util.HashMap;

public class 수열찾기 {
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
            // n*2 있는지 체크
            int key = n * 2;
            if(!map.containsKey(key)) continue;
            if(map.get(key)==1) map.remove(key);
            else map.put(key, map.get(key)-1);
            answer[idx++]=n;
        }

        return answer;
    }

    public static void main(String[] args){
        수열찾기 T = new 수열찾기();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
