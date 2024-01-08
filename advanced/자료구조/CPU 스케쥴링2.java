import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class cpu스케쥴링2 {

    public int[] solution(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        int[][] program = new int[tasks.length][3];

        // index 정보와 함께 tasks 저장
        for (int i = 0; i < n; i++) {
            program[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        // 호출시간 기준 오름차순 정렬
        Arrays.sort(program, Comparator.comparingInt(o -> o[0]));

        // 1) 실행시간 오름차순 2) 작업번호 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);

        int i = 0, ft = 0, idx = 0;
        // 2. 모든 cpu 실행할 때까지 반복
        while (idx < n) {

            // 공백 타임 제거를 위해
            if(pq.isEmpty() && ft <= program[i][0]) ft += program[i][0];

            while (i < n && ft >= program[i][0]) {
                pq.add(program[i++]);
            }

            if (!pq.isEmpty()) {
                int[] runCPU = pq.poll();
                answer[idx++] = runCPU[2];
                ft += runCPU[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        cpu스케쥴링2 T = new cpu스케쥴링2();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}

