import java.util.*;

class Solution {
    
    int rowSize, colSize;

    // 상, 하 , 좌, 우
    int[] tb = new int[]{-1, 1, 0, 0};
    int[] lr = new int[]{0, 0, -1, 1};
    public int solution(int[][] land) {

        rowSize = land.length;
        colSize = land[0].length;

        int[] result = new int[colSize];

        // land를 0,0부터 탐색
        for(int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {

                // 현재 탐색 지역이 오일이 아니면 패스
                if(isNotOil(land[r][c])) continue;

                int cnt = 0;
                HashSet<Integer> colSet = new HashSet<>();
                Queue<int[]> q = new LinkedList();
                q.add(new int[]{r,c});

                // 오일일경우 덩어리 영역 탐색
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    int currRow = curr[0];
                    int currCol = curr[1];
                    if (isNotOil(land[currRow][currCol]))continue;
                    cnt++;
                    colSet.add(currCol); // 석유가 포함되는 행 저장
                    land[currRow][currCol] = 0;
                    for(int i = 0; i < 4; i++) {
                        int nextRow = currRow+tb[i];
                        int nextCol = currCol+lr[i];

                        if(isNotLand(nextRow, nextCol)) continue;
                        if (isNotOil(land[nextRow][nextCol])) continue;
                        q.add(new int[]{nextRow,nextCol});
                    }
                }

                // 석유가 포함되는 행에 덩어리 수 저장
                for (int col : colSet) {
                    result[col] += cnt;
                }

            }
        }

        return Arrays.stream(result).max().getAsInt();

    }

    private boolean isNotLand(int r, int c) {
        return r < 0 || c < 0 || r >= rowSize || c >= colSize;
    }

    private boolean isNotOil(int a) {
        return a!=1;
    }
}
