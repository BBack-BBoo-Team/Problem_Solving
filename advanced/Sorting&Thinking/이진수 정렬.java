import java.util.Arrays;
import java.util.PriorityQueue;

public class 이진수정렬 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            int cnt1 = chkCntNumberOne(toBinary(o1));
            int cnt2 = chkCntNumberOne(toBinary(o2));
            return cnt1 == cnt2 ? o1 - o2 : cnt1 - cnt2;
        }));

        for(int n : nums) pq.add(n);
        for(int i = 0; i < nums.length; i++) answer[i] = pq.poll();
        return answer;
    }

    private String toBinary(int n) {
        return Integer.toBinaryString(n);
    }

    private int chkCntNumberOne(String s) {
        int cnt = 0;
        for(char ch : s.toCharArray()) {
            if (ch=='1') cnt++;
        }
        return cnt;
    }

    public static void main(String[] args){
        이진수정렬 T = new 이진수정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
