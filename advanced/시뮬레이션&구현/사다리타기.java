
import java.util.Arrays;

// 35분 소요
public class 사다리타기 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        int depth = ladder.length; // 가로줄 수
        int[][] ladderLine = new int[n][depth]; // 가로줄 여부, -1:좌, 1:우, 0:선 없음

        // 1. 가로줄 여부 정보 저장 -> 이중 for
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                int lineIdx = ladder[i][j];
                ladderLine[lineIdx-1][i] = 1;
                ladderLine[lineIdx][i] = -1;
            }
        }

        // 2. 사다리의 0번부터 체크
        for (int i = 0; i < n; i++) {
            int move = i;
            for (int j = 0; j < depth; j++) {
                if(ladderLine[move][j] == 1) move++;
                else if (ladderLine[move][j] == -1) move--;
            }
            answer[move] = (char) (i+65);
        }

        return answer;
    }

    public static void main(String[] args){
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
