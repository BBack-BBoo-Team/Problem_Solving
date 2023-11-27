import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        // 1. 결과를 저장할 스택 초기화
        Stack<Integer> st = new Stack<Integer>();
        // 2. arr의 0번 데이트 스택에 저장
        st.push(arr[0]);
        // 3. arr 1번부터 순회
        for(int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            // 4. 스택에 제일 위에 있으면 패스
            if (curr==st.peek()) continue;
            // 5. 없으면 PUSH    
            st.push(curr);
        }
        
        // 6. 스택 사이즈에 해당하는 결과 배열 초기화
        int[] answer = new int[st.size()];
        // 7. 배열에 마지막 인덱스부터 스택의 값 삽입
        for (int i = st.size()-1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        return answer;
    }
}
