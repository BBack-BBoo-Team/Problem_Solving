// 하나씩 내려온다고 생각하지 말고, 한번에 내려온다고 생각
// 최대 시간복잡도 : 10,000번 연산
public class 사다리타기_sol {

    public char[] solution(int n, int[][] ladder){

        char[] answer = new char[n];
        // 1. 사다리 결과 초기화 (초기는 가로줄이 없다고 가정)
        for (int i = 0; i < n; i++) answer[i] += (char) (i+65);
        // 2. 가로줄의 depth를 0부터 순회
        for (int i = 0; i < ladder.length; i++) {
            // 3. 포함되는 세로줄의 자리교환
            for (int j = 0; j < ladder[i].length; j++) {
                char temp = 0x00;
                int line = ladder[i][j];
                temp = answer[line];
                answer[line] = answer[line-1];
                answer[line-1] = temp;
            }
        }

        return answer;
    }
}
