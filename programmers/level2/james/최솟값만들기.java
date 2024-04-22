// 완전 탐색 or 정렬
// 1) 정렬
// a는 오름차순 정렬, b는 내림차순 정렬 후 각각의 인덱스 곱하여 합 누적
import java.util.*;
class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int totalIdx = A.length-1;
        for(int i = 0; i <= totalIdx; i++) {
            answer+= A[i] * B[totalIdx-i];
        }

        return answer;
    }
}
