import java.util.ArrayList;
import java.util.Collections;

// 좀 어려운 문제
public class 모임장소 {
    public int solution(int[][] board){
        int answer=0;
        int width = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        int k = 0;
        for(int i = 0; i < width; i++) {

            for(int j = 0; j < width; j++) {
                if(board[i][j]==1) {
                    row.add(i);
                    col.add(j);
                    k++;
                }
            }
        }
        Collections.sort(col);
        int center = k/2;

        for (int i = 0; i < k; i++) {
            answer += Math.abs(row.get(i)-row.get(center)) + Math.abs(col.get(i)-col.get(center));
        }

        return answer;
    }

    public static void main(String[] args){
        모임장소 T = new 모임장소();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
