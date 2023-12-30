
import java.util.*;

public class 회의실 만남 {

    public int[] solution(int[] enter, int[] exit){

        int nums = enter.length;
        int[] answer = new int[nums];

        int[] enterIdx = new int[nums];
        int[] enTime = new int[nums];
        int[] exTime = new int[nums];

        // 1. 각 사람마다 들어오는 순서 저장
        for (int i = 0; i < nums; i++) {
            int idx = enter[i]-1;
            enterIdx[idx] = i;
        }

        int idx = 0, time = 0;
        // 2. 나가는 사람 기준 순회
        for (int i = 0; i < nums; i++) {
            int exitStudent = exit[i]-1;
            int exitIdx = enterIdx[exitStudent];
            time++;
            for (int j = idx; j <= exitIdx; j++) {
                if(enTime[enter[j]-1]!=0) continue;
                enTime[enter[j]-1] = time;
                time++;
            }

            exTime[enter[exitIdx]-1] += time;
            idx = exitIdx+1;
        }

        // 3. 시간 범위 별 겹치는 사람 체크
        for (int i = 0 ; i < nums; i++) {

            for (int j = i+1; j < nums; j++) {

                if (exTime[i] < enTime[j] || exTime[j] < enTime[i]) continue;
                answer[i]++;
                answer[j]++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        회의실만남 T = new 회의실만남();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
