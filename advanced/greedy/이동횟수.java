import java.util.Arrays;

// 앞 문제와 동일
public class 이동횟수 {
    public int solution(int[] nums){
        int answer = 0, left = 0, right = nums.length-1;
        Arrays.sort(nums);
        while(left<=right) {
            if(nums[left]+nums[right] <= 5) left++;
            right--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        이동횟수 T = new 이동횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
