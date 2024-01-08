import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가장많이사용된회의실 {
    public int solution(int n, int[][] meetings){
        int answer = 0;
        int[] result = new int[n];
        int[] endTime = new int[n];

        Arrays.sort(meetings, (o1,o2) -> o1[0] - o2[0]);

        for(int i = 0; i < n; i++) {
            endTime[i] = meetings[i][1]; // 회의실 초기 설정
            result[i]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 대기중인 회의실 인덱스 저장
        Queue<Integer> wait = new LinkedList<>();
        int idx = n, t = meetings[n][0];
        while(pq.size() != n) {

            for(int i = 0; i < n; i++) {
                if(t>=endTime[i]) pq.add(i);
            }

            if(!pq.isEmpty() && !wait.isEmpty()) {
                int room = pq.poll();
                endTime[room] += wait.poll();
                result[room]++;
            };

            if(idx < meetings.length) {
                int start = meetings[idx][0];
                int end = meetings[idx][1];

                if (t == start) {
                    if (pq.isEmpty()) {
                        wait.add(end - start);
                    } else {
                        int room = pq.poll();
                        endTime[room] = end;
                        result[room]++;
                    }
                    idx++;
                }
            }

            t++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max < result[i]) {
                answer = i;
                max = result[i];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        가장많이사용된회의실 T = new 가장많이사용된회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
