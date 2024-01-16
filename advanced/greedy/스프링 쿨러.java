import java.util.Arrays;

public class 스프링쿨러 {

    // nums의 각 인덱스가 갖는 물의 범위를 새로운 이차원 배열에 저장
    // 첫번째 기준 오름차순
    // 이차원 배열 인덱스 하나씩 탐색 -> O(n)
    // 현재 기준이 N 이상이면 종료
    // 시작 범위가 현재기준 이하 -> 둘째값 중 최대값 다음기준에 저장
    // 시작 범위가 현재기준보다 크면 현재 기준에 다음 기준 저장하고 answer +1
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] arr = new int[n+1][2];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==0) {
                arr[i] = new int[]{0,0};
            } else {
                arr[i][0] = i - nums[i];
                arr[i][1] = i + nums[i];
            }
        }

        Arrays.sort(arr, (o1,o2) -> o1[0] - o2[0]);
        int start = 0, end = 0;
        for(int[] curr : arr) {
            int left = curr[0];
            int right = curr[1];

            if(start < left) {
                answer++;
                start = end;
                if(left > start) return -1;
            }

            end = Math.max(end, right);
        }

        if(end==n) answer+=1;
        return answer;
    }

    public static void main(String[] args){
        스프링쿨러 T = new 스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
