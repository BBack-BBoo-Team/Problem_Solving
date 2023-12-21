// 소요시간 : 28분
// board의 크기 (3 <= n <= 100)
// board에서 0은 빈 공간이고, 1은 장애물이다.
// board에서 로봇의 시작위치는 0행 0열(가장 왼쪽 가장 위)이다.
// 변수 k는 1,000이하의 자연수이다.
public class 청소 {

    // 방향키 (우, 하, 좌, 상)
    final int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int currDir;

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        currDir = 0;

        while (k-->0) {

            int nextRow = answer[0] + dir[currDir][0];
            int nextCol = answer[1] + dir[currDir][1];

            // 1. 현재 진행 방향 앞에 장애물 & 막다른 길 체크, 있으면 회전
            if (isNotLoad(nextRow, nextCol, board)) rotation();
            else if (isObstacle(nextRow, nextCol, board))rotation();
            else move(answer); // 이동
        }

        return answer;
    }

    // 막다른 길
    private boolean isNotLoad(int r, int c, int[][] board) {
        return r == board.length || c == board.length || r < 0 || c < 0;
    }

    // 장애물
    private boolean isObstacle(int r, int c, int[][] board) {
        return board[r][c] == 1;
    }

    // 회전
    private void rotation() {
        if (currDir==3) currDir=0;
        else currDir++;
    }

    // 직진
    private void move(int[] answer) {
        answer[0] += dir[currDir][0];
        answer[1] += dir[currDir][1];
    }
