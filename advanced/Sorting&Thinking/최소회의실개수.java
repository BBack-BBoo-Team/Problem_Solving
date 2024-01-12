import java.util.Arrays;
import java.util.PriorityQueue;

public class 최소회의실개수 {
    public int solution(int[][] meetings){
        int answer = 0;
        Arrays.sort(meetings,(o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);

        for (int[] meet : meetings) {

            if(pq.isEmpty())
            {
                pq.add(meet); continue;
            }

            if(pq.peek()[1] <= meet[0]) {
                pq.poll();
                pq.add(meet);
            }else {
                pq.add(meet);
            }
            answer = Math.max(pq.size(), answer);
        }

        return answer;
    }

    public static void main(String[] args){
        최소회의실개수 T = new 최소회의실개수();
        System.out.println(T.solution(new int[][]{{0, 10}, {12, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
