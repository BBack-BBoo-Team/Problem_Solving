public class 바둑대회 {

    // answer 전역 변수 선언
    int answer, n;
    // 방문여부 저장 배열 선언
    boolean[] isVisit;
    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        n = cans.length;
        isVisit = new boolean[n];

        dfs(0,0, cans);

        return answer;
    }

    // dfs
    // 탐색 횟수가 n/2 도달했을 때 누적한 합에서 탐색하지 않은 인덱스의 수의 합을 뺀다.
    // answer와 비교후 작은 값 answer에 저장
    // 0부터 끝까지 순회하면서 합을 누적
    private void dfs(int cnt, int sum, int[][] point) {

        if(cnt == n/2) {
            int blackSum = 0;
            for(int i = 0; i < n; i++) {
                if(!isVisit[i]) blackSum += point[i][1];
            }
            answer = Math.min(answer, Math.abs(sum - blackSum));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isVisit[i]) continue;
            isVisit[i] = true;
            dfs(cnt+1, sum+point[i][0], point);
            isVisit[i] = false;
        }
    }

    public static void main(String[] args){
        바둑대회 T = new 바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
