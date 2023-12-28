// 풀이 오류
// 1) 1, 1, 2 -> 0개 나와야함
public class 최대길이 바이토닉 수열 {

    public int solution(int[] nums){
        int answer = 0;
        int idx = 0;

        while(idx < nums.length-1) {
            int cnt = 0;
            boolean up = true;
            for(int j = idx+1; j < nums.length; j++) {
                int curr = nums[idx];
                int next = nums[j];

                if (next == curr) {
                    idx++;
                    break;
                }

                if(up) {
                    if(next < curr) up = false;
                } else {
                    if(next > curr) break;
                }
                cnt++;
                idx = j;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
