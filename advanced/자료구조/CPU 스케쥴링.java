
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class cpu스케쥴링 {

    public int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];
        int t = 0, idx = 0;

        // cpu 별 인덱스 저장
        HashMap<int[], Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(tasks[i], i);
        }

        // 1. tasks 호출시간 오름차순 정렬
        Arrays.sort(tasks,(o1,o2)->o1[0]-o2[0]);

        // 2. 우선순위 큐에 첫번째 인덱스 task 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int i = 0;
        // 3. 모든 cpu 실행할 때까지 반복
        while(idx < n) {
            while(i < n && t>=tasks[i][0]) {
                pq.add(new int[]{tasks[i][1], map.get(tasks[i])});
                i++;
            }

            if(!pq.isEmpty()) {
                int[] runCPU = pq.poll();
                answer[idx] = runCPU[1];
                t += runCPU[0];
                idx++;
            } else {
                t++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        cpu스케쥴링 T = new cpu스케쥴링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
