import java.util.Arrays;

// 어차피 k 이하번으로만 탐색하기 때문에 시간복잡도 O(K)로 연산횟수에선 문제없음
// 이차원 배열과 매번 answer에 좌표를 저장하기 때문에 불필요하게 메모리 사용
public class 좌석번호 {

    // 상, 우, 하, 좌
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int dir;

    boolean[][] map;

    public int[] solution(int c, int r, int k){
        int[] answer = {1,1};
        map = new boolean[r+1][c+1]; // 방문한 곳은 true
        map[1][1] = true;

        if (k > r*c) return new int[]{0,0};

        while (k>1) {

            int nextX = answer[0] + dx[dir]; // -> c
            int nextY = answer[1] + dy[dir]; // -> r

            if(isWall(nextX,nextY,c,r)) {
                rotation();
            } else {
                answer = new int[]{nextX, nextY};
                map[nextY][nextX] = true;
                k--;
            }

        }

        return answer;
    }

    boolean isWall(int x, int y, int c, int r) {
        return x > c || y > r || x == 0 || y == 0 || map[y][x];
    }

    void rotation() {
        dir = (dir+1)%4;
    }
}
