
public class 과일가져가기 {

    public int solution(int[][] fruit){
        int answer = 0;

        int n = fruit.length; // 학생수
        int[][] peek = new int[n][2];
        boolean[] notExchange = new boolean[n];

        // 각 학생들이 peek할 과일 수를 answer에 저장
        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++) {
                if (min > fruit[i][j]) {
                    min = fruit[i][j];
                    peek[i][0] = j;
                    peek[i][1] = min;
                }
            }

            for(int j = 0; j < 3; j++) {
                if(j==peek[i][0]) continue;
                if(fruit[i][j]==peek[i][1]) notExchange[i] = true;
            }
            answer += min;
        }


        for(int i = 0; i < n-1; i++) {
            // 1. 현재 학생이 교환할지 체크
            if(notExchange[i]) continue;

            // 현재 학생 다음 순번중 가장 작은 순번 체크
            for (int j = i+1; j < n; j++) {

                // 교환할지 체크
                if(notExchange[j] || peek[i][0] == peek[j][0]) continue;
                if(fruit[i][peek[j][0]]-1 == peek[i][1]) continue;
                notExchange[j] = true;
                // 그리고 answer에 +2 하고 break
                answer+=2;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        과일가져가기 T = new 과일가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
