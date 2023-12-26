import java.util.Arrays;

// 둘이 같이 움직이는 것이 포인트
public class 잃어버린 강아지 {

    // 상-우-하-좌
    final int[] dr = new int[]{-1,0,1,0};
    final int[] dc = new int[]{0,1,0,-1};
    int dogDir, humanDir;

    // 0-빈칸, 1-나무, 2-현수, 3-강아지
    // map 10칸 고정
    public int solution(int[][] board){
        int answer = 0;
        int[] human = new int[2];
        int[] dog = new int[2];

        // 1. 현수와 개 위치 찾기
        boolean findHuman = false, findDog = false;
        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(board[i][j]==2) {
                    human[0] = i;
                    human[1] = j;
                    findHuman = true;
                }
                if(board[i][j]==3) {
                    dog[0] = i;
                    dog[1] = j;
                    findDog = true;
                }
            }
            if (findHuman && findDog) break loop;
        }

        // 2. 이동
        while (answer < 10_000) {

            int human_nr = human[0]+dr[humanDir];
            int human_nc = human[1]+dc[humanDir];
            int dog_nr = dog[0]+dr[dogDir];
            int dog_nc = dog[1]+dc[dogDir];

            // human
            if(isNotLoad(human_nr, human_nc, board)) rotation(true);
            else human = new int[]{human_nr, human_nc};

            // dog
            if(isNotLoad(dog_nr, dog_nc, board)) rotation(false);
            else dog = new int[]{dog_nr, dog_nc};

            answer++;
            if (Arrays.equals(human, dog)) return answer;
        }

        return 0;
    }

    // 막다른 길 or 나무
    boolean isNotLoad(int r, int c,int[][] board) {
        return r >= 10 || c >= 10 || r < 0 || c < 0 || board[r][c] == 1;
    }
}

    void rotation(boolean isHuman) {
        if(isHuman) humanDir = (humanDir+1)%4;
        else dogDir = (dogDir+1)%4;
    }
