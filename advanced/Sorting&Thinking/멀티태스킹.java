import java.util.LinkedList;
import java.util.Queue;

// int = 2,147,483,647
// 1 <= k <= 2*10^13 -> 14자리 -> int 넘어 (long)
// time limit 발생...
public class 멀티태스킹 {

    // k초 전까지 작업 진행하고, 정전되었을 때 queue가 비었으면 -1, 아니면 제일 앞 작업의 인덱스 추출
    public int solution(int[] tasks, long k) {
        Queue<int[]> work = new LinkedList<>(); // 0번: 인덱스, 1번: 작업시간
        for(int i = 0; i < tasks.length; i++) work.add(new int[]{i+1,tasks[i]});
        while(k-->0 && !work.isEmpty()) {
            int[] curr = work.poll();
            if (curr[1]==1) continue;
            work.add(new int[]{curr[0], curr[1]-1});
        }

        if(work.isEmpty()) return -1;
        else return work.poll()[0];
    }

    public static void main(String[] args){
        멀티태스킹 T = new 멀티태스킹();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
