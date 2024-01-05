import java.util.Arrays;

// 나의 풀이 -> 정렬 후 순회
// O(N)
public class 최대길이연속수열 {
    public int solution(int[] nums){
        int answer = 0;

        // nums 오름차순 정렬
        Arrays.sort(nums);
        int pre = nums[0], cnt = 1;
        // nums 순회하며 cnt 체크
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if(pre==curr) continue;
            else if(pre+1==curr) cnt++;
            else {
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
            pre = curr;
        }
        answer = Math.max(answer, cnt);
        return answer;
    }

    public static void main(String[] args){
        최대길이연속수열 T = new 최대길이연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
