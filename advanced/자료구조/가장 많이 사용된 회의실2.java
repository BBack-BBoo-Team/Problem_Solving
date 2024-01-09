import java.util.*;

public class 가장많이사용된회의실2 {
    public int solution(int n, int[][] meetings) {
        int answer = 0;

        // 1) 회의 정보 배열을 시작시작 오름차순 정렬
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        // 진행중 회의, 0번 회의실 종료시간, 1번 회의실 번호
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        int[] cnt = new int[n];
        // 2) meetings 순회
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            // 3) 0 ~ n-1 인덱스까지는 pq에 그냥 저장 -> 회의종료시간과 인덱스
            if(i < n) {
                pq.add(new int[]{end, i});
                cnt[i]++; // 진행한 인덱스에 cnt+1
            }
            else {
                // 4) 진행중인 회의 하나 poll
                int[] curr = pq.poll();
                int endTime = curr[0];
                int idx = curr[1];

                // --- 회의 종료시간보다 현재 회의 시작 시간이 이상일경우 회의 종료시간 그냥 삽입
                if(endTime <= start) endTime = end;
                // --- 회의 종료시간보다 시작시간이 작을 경우 회의종료시간 + 현재 회의 종료 시간 - 현재 회의 시작 시간
                else endTime += end-start;
                // pq에 다시 저장
                pq.add(new int[]{endTime, idx});
                // 5) 진행한 인덱스에 cnt+1
                cnt[idx]++;
            }

        }

        // cnt에서 가장 큰 값의 인덱스 출력
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(max < cnt[i]) {
                answer = i;
                max = cnt[i];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        가장많이사용된회의실2 T = new 가장많이사용된회의실2();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
