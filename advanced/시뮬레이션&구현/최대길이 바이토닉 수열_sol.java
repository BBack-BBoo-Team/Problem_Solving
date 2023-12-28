
import java.util.ArrayList;

public class 최대길이바이토닉수열_sol {

    public int solution(int[] nums) {
        // 1. 봉우리 지점을 찾는다. (좌, 우의 수보다 큰 지점)
        ArrayList<Integer> peek = new ArrayList<>();
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i-1] < nums[i] && nums[i+1] < nums[i]) peek.add(i);
        }
        int answer = 0;
        if (peek.size()==0) return answer;
        // 2. 봉우리 지점을 기준으로 좌, 우 탐색 진행
        for (int p : peek) {
            // 3. 좌,우 각각에 갈 수 있는 길이 카운트
            int cnt=1;
            int leftIdx = p;
            int rightIdx = p;
            // left
            while(leftIdx > 0){
                if(nums[leftIdx-1] >= nums[leftIdx]) break;
                cnt++;
                leftIdx--;
            }
            // right
            while(rightIdx < nums.length-1){
                if(nums[rightIdx+1] >= nums[rightIdx]) break;
                cnt++;
                rightIdx++;
            }

            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
