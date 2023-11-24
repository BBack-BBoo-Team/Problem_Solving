import java.util.Stack;

public class 크레인인형뽑기게임 {

    int[] maxStageArr;
    public int solution(int[][] board, int[] moves) {

        int size = board.length;
        boolean[] isMaxStage = new boolean[size];
        maxStageArr = new int[size];
        for(int i = 0; i < size; i++) maxStageArr[i] = -1;

        // 1. 각 행의 최대층(열) 탐색
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0 || isMaxStage[j]) continue;
                maxStageArr[j] = i;
                isMaxStage[j] = true;
            }
        }
        // 2. 게임 start
        Stack<Integer> stack = new Stack<>();
        return gameStart(stack, board, moves);;
    }


    private int gameStart(Stack<Integer> stack, int[][] board, int[] moves) {

        int cnt = 0;
        // move 순회, (move : 행, 최대층 : 열)에 해당하는 인형을 stack에 push
        for (int i = 0; i < moves.length; i++) {

            int pick = moves[i]-1;
            int maxRow = maxStageArr[pick];

            // 최대층이 row 범위를 벗어 나면 패스 (더 이상 없음)
            if(maxRow >= board.length) continue;

            int doll = board[maxRow][pick];

            // Stack 제일 위에 있다면 넣지 않고, 위에 인형도 제거,
            if (stack.isEmpty() || stack.peek() != doll) {
                stack.push(doll);
            } else {
                stack.pop();
                cnt+=2;
            }

            //최대층에 +1
            maxStageArr[pick]++;
        }

        return cnt;
    }
}
