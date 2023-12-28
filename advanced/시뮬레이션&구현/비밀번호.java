public class 비밀번호 {

    int[][] pad;
    public int solution(int[] keypad, String password){
        int answer = 0;
        pad = new int[10][2]; // 0번은 더미
        // 이차원 배열에 각 인덱스에 위치할 r,c 저장
        for(int i = 0; i < 9; i++) {
            // 몫이 열, 나머지가 행
            int r = i / 3;
            int c = i % 3;
            int idx = keypad[i];
            pad[idx] = new int[]{r,c};
        }

        // password 처음부터 순회
        for(int i = 1; i < password.length(); i++) {
            String curr = String.valueOf(password.charAt(i));
            String past = String.valueOf(password.charAt(i-1));

            // 자기 자신이면 0초
            if(curr.equals(past)) continue;
            // 이전 위치에서 현재 위치까지 인접한지 체크
            else if (isNearNode(Integer.parseInt(past), Integer.parseInt(curr))) {
                answer+=1;
            }
            // 인접 X
            else answer+=2;
        }

        return answer;
    }

    // 현재 위치가 이전 위치와 인접한지 체크
    // 상, 하, 좌, 우, 대각선
    // 현재 위치 - 이전 위치 > 1 or < -1 (인접 x)
    private boolean isNearNode(int past, int curr) {
        int[] pastPoint = pad[past];
        int[] currPoint = pad[curr];
        int diffRow = currPoint[0] - pastPoint[0];
        int diffCol = currPoint[1] - pastPoint[1];
        if (diffRow > 1 || diffRow < -1 || diffCol > 1 || diffCol < -1) return false;
        return true;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
