
import java.util.Arrays;

public class 같은빈도수만들기 {
    public int[] solution(String s){
        int[] answer = new int[5];
        int[] cntArr = new int[5];
        // 1) 배열에 문자 각각의 cnt 저장
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            cntArr[idx]++;
        }

        // 최대 많은 수 추출
        int max = Arrays.stream(cntArr).max().getAsInt();

        // 2) 순회하면서 (max - 배열값)을 answer 각 자리에 저장
        for (int i = 0; i < 5; i++) {
            answer[i] = max - cntArr[i];
        }

        return answer;
    }

    public static void main(String[] args){
        같은빈도수만들기 T = new 같은빈도수만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}
