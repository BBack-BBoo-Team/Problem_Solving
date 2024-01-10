import java.util.Arrays;

public class 카드가져가기 {

    // i) 우선권을 언제쓸거냐
    // 내림차순 정렬 후 2개씩 묶었을 때
    // 두 값의 차이가 큰 순으로 정렬
    // K 만큼은 큰 수를 선택
    // 나머지는 작은 수 선택
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;

        // 1. nums 오름차순 정렬 -> 이차원에 저장할때 큰수부터 저장
        Arrays.sort(nums);
        // 2. 이차원 배열에 두개씩 저장
        int[][] peek = new int[nums.length/2][2];

        for(int i = nums.length-1, peekIdx = 0; i > 0; i-=2, peekIdx++) {
            peek[peekIdx][0] = nums[i];
            peek[peekIdx][1] = nums[i-1]; // 1번보다는 이하인 수
        }
        // 3. 이차원 배열 내의 데이터끼리 차이로 내림차순 정렬
        Arrays.sort(peek, (o1, o2) -> (o2[0]-o2[1]) == (o1[0]-o1[1]) ? o2[0]-o1[0] : (o2[0]-o2[1]) - (o1[0]-o1[1]));
        // 4. 이차원 배열 순회
        for(int i =0; i < n/2; i++) {
            if(i<k) answer += peek[i][0]; // 5. k 까지는 큰 수를 선택하여 answer에 저장
            else answer += peek[i][1]; // 6. 나머지는 작은 수를 선택하여 answer에 저장
        }
        return answer;
    }

    public static void main(String[] args){
        카드가져가기 T = new 카드가져가기();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
