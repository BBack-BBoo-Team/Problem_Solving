import java.util.*;

public class 모의고사 {

    final String[] students = {"12345", "21232425", "3311224455"};

    public int[] solution(int[] answers) {

        int maxCnt = 0;
        int[] temp = new int[3]; // 정답수 저장 배열
        int idx = 0;
        // 학생 순회
        for(String student : students) {
            int cnt = 0;
            int solveCnt = student.length();

            for(int i = 0; i < answers.length; i++) {
                // 현재 인덱스를 학생의 찍는 번호의 수로 나누어 몫을 구한다.
                int num = i % solveCnt;
                // 몫을 인덱스로 하여 학생의 찍는 번호를 구한다.
                int stuAns = student.charAt(num) - '0';
                // 번호와 정답이 같으면 cnt+1
                if (answers[i]==stuAns) cnt++;
            }
            // 학생의 정답수와 최대정답수 값 저장
            temp[idx] = cnt;
            idx++;
            maxCnt = Math.max(cnt, maxCnt);
        }

        // 학생별 정답 수를 저장한 배열에서 maxCnt와 일치하는 인덱스를 결과 배열에 저장
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(maxCnt==temp[i]) result.add(i+1);
        }
        // ArrayList를 배열로 변환
        return result.stream().mapToInt(i->i).toArray();
    }
}
