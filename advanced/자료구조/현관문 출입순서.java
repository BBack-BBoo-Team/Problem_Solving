import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// 1초 전 x, 나가는 사원
// 1초 전 나감, 나가는 사원
// 1초 전 들어옴, 들어오는 사원
// 같은 방향 여러명, 사원번호가 가장 작은 사람
public class 현관문출입순서 {
    public int[] solution(int[] arrival, int[] state){

        int n = arrival.length; // 사원 수
        int[] answer = new int[n];

        // 1. 도착한 시간별 사원 인덱스 HashMap 저장
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int arrivalTime = arrival[i];
            if(!map.containsKey(arrivalTime)) map.put(arrivalTime, new ArrayList<>());
            map.get(arrivalTime).add(i);
        }

        int time = -1, resultIdx = 0, currDoor = 1, cnt = 0;
        PriorityQueue<Integer>[] pq = new PriorityQueue[2];
        for(int i= 0; i < 2; i++) {
            pq[i] = new PriorityQueue<>();
        }
        while(cnt < n) {
            time++;
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(time)) {
                list = map.get(time);
                for(int i : list) pq[state[i]].add(i);
            }

            if(!pq[0].isEmpty() || !pq[1].isEmpty()) {

                if(currDoor==1 ) {
                    if(pq[1].isEmpty()) currDoor=0;
                    else resultIdx = pq[1].poll();
                }

                if(currDoor==0) {
                    if(pq[0].isEmpty()) {
                        resultIdx = pq[1].poll();
                        currDoor = 1;
                    }
                    else resultIdx = pq[0].poll();
                }

                answer[resultIdx] = time;
                cnt++;
            } else {
                currDoor = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        현관문출입순서 T = new 현관문출입순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
