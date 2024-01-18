public class 줄다리기 {

    int cnt, answer;
    boolean[] isUse;
    boolean[][] hate;
    public int solution(int[][] fight){
        answer = 0; cnt = 0;
        isUse = new boolean[8];
        hate = new boolean[8][8];
        for(int i = 0; i < fight.length; i++) {
            int from = fight[i][0];
            int to = fight[i][1];
            hate[from][to] = true;
            hate[to][from] = true;
        }

        dfs(0,0);
        return answer;
    }

    private void dfs(int cnt, int curr) {

        if(cnt==7) {
            answer++;
            return;
        }

        for(int i = 1; i < 8; i++) {
            if(isUse[i]) continue;
            if(cnt>=1 && hate[curr][i]) continue;
            isUse[i] = true;
            dfs(cnt+1, i);
            isUse[i] = false;
        }
    }

    public static void main(String[] args){
        줄다리기 T = new 줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
