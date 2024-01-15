import java.util.Arrays;

public class 침몰하는타이타닉 {

    // 1. 오름차순 정렬
    // 2. 투포인터 탐색 진행
    // 3. left(끝)과 right(끝)을 더했을 때 m 보다
    // ㄴ 작다 cnt+1, left+1, right-1
    // ㄴ 크다 cnt+1, right-1
    // left가 right보다 커지는 순간 종료
    public int solution(int[] nums, int m){
        int answer = 0, left = 0, right = nums.length-1;
        Arrays.sort(nums);
        while(left <= right) {
            if(nums[left]+nums[right]<=m) left++;
            right--;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        침몰하는타이타닉 T = new 침몰하는타이타닉();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 160));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
