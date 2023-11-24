import java.util.Queue;
import java.util.LinkedList;

// 테스트 24 - 계속 시간초과 나오는 중 이유가 뭘까?
// 데이터가 최대 300,000 -> O(n) 이하
// 반례 -> 큐1 = [1, 1, 1, 8, 10, 9] 큐2 = [1, 1, 1, 1, 1, 1]
class Solution {
    
    long sum1, sum2;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // 배열 타입의 두 큐를 ArrayList로 이동
        Queue<Long> q1 = new LinkedList<>();
        for (int q : queue1) {
            q1.add((long) q);
            sum1 += q;
        }
        
        Queue<Long> q2 = new LinkedList<>();
        for (int q : queue2) {
            q2.add((long) q);
            sum2 += q;
        }
        
        int maxCnt = queue1.length*3;
        while(sum1 != sum2) {
            
            if(answer >= maxCnt) return -1;
            // 더 작은 합의 큐에서 poll 후 다른 큐에 add, cnt+1;
            if (sum1 < sum2)  {
                long num = q2.poll();
                q1.add(num);
                sum1 += num;
                sum2 -= num;
            } else {
                long num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            }
            
            answer++;
        }
        
        return answer;
    }
     
}
