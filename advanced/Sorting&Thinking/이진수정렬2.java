import java.util.Arrays;

// 이진수 시에 1의 개수 = 10진수에서 2로 계속 나눌때 나머지 1의 개수
public class 이진수정렬2 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        // 1. 10 진수와 해당 값 이진수의 1의 개수 이차원 배열에 저장
        int[][] toBinaryArr = new int[nums.length][2];
        for(int i =0;i<nums.length;i++) {
            toBinaryArr[i][0] = nums[i];
            toBinaryArr[i][1] = chkOneToBinary(nums[i]);
        }
        // 2. 이차원 배열 정렬 1) 1의 개수, 2) 10진수 오름차순
        Arrays.sort(toBinaryArr, (o1,o2) -> o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        // 3. 정렬한 10진수 answer 에 저장
        for(int i = 0; i < nums.length; i++) answer[i] = toBinaryArr[i][0];
        return answer;
    }

    private int chkOneToBinary(int n) {
        int cnt = 0;
        while(n > 0) {
            cnt += n%2;
            n/=2;
        }
        return cnt;
    }

    public static void main(String[] args){
        이진수정렬2 T = new 이진수정렬2();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

}
