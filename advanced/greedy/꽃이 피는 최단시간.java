import java.util.Arrays;

public class 꽃이피는최단시간 {

    // i, plantTime + growTime
    // [1] 내림차순 정렬
    // pt = 0, gt = 0
    // 정렬한 배열 순회
    // pt + [0]
    // 마지막 배열이 pt + [0] + [1]
    public int solution(int[] plantTime, int[] growTime) {
        int answer = 0, n = plantTime.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }

        Arrays.sort(arr, (o1,o2) -> o2[1] == o1[1] ? o1[0] - o2[0] : o2[1] - o1[1]); // 오름차순하고 거꾸로 순회

        int pt = 0;
        for(int i = 0; i < n; i++) {
            int gt = 0;
            pt += arr[i][0];
            gt = pt+arr[i][1];
            answer = Math.max(gt, answer);
        }

        return answer;
    }

    public static void main(String[] args){
        꽃이피는최단시간 T = new 꽃이피는최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
