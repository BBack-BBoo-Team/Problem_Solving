package level1;

import javax.swing.*;
import java.util.HashMap;

/**
 * 카카오 성격 유형 검사지
 * 1번 지표 : 라이언형(R), 튜브형(T)
 * 2번 지표 : 콘형(C), 프로도형(F)
 * 3번 지표 : 제이지형(J), 무지형(M)
 * 4번 지표 : 어피치형(A), 네오형(N)
 * <p>
 * 선택지 : 1,2,3,4,5,6,7
 * 점수 : L3, L2, L1, -, R1, R2, R3
 * 점수가 동일할 시 사전순 출력
 */
public class kang_성격유형검사하기 {

    static HashMap<String, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (int i = 0; i < survey.length; i++) {

            String firstWord = String.valueOf(survey[i].charAt(0));
            String secondWord = String.valueOf(survey[i].charAt(1));

            setPointOfType(choices, i, firstWord, secondWord);
        }

        String[] resultArr = new String[4];

        selectType(resultArr, "R", "T", 0);
        selectType(resultArr, "C", "F", 1);
        selectType(resultArr, "J", "M", 2);
        selectType(resultArr, "A", "N", 3);

        for (String type : resultArr) {
            answer += type;
        }
        return answer;
    }

    private void selectType(String[] resultArr, String first, String second, int index) {
        if (map.get(first) == null || map.get(second) == null || map.get(first) >= map.get(second)) {
            resultArr[index] = first;
        } else {
            resultArr[index] = second;
        }
    }

    private void setPointOfType(int[] choices, int i, String firstWord, String secondWord) {
        switch (choices[i]) {
            case 1:
                map.put(firstWord, map.getOrDefault(firstWord, 0) + 3);
                map.put(secondWord, map.getOrDefault(secondWord, 0));
                break;
            case 2:
                map.put(firstWord, map.getOrDefault(firstWord, 0) + 2);
                map.put(secondWord, map.getOrDefault(secondWord, 0));
                break;
            case 3:
                map.put(firstWord, map.getOrDefault(firstWord, 0) + 1);
                map.put(secondWord, map.getOrDefault(secondWord, 0));
                break;
            case 4:
                break;
            case 5:
                map.put(secondWord, map.getOrDefault(secondWord, 0) + 1);
                map.put(firstWord, map.getOrDefault(firstWord, 0));
                break;
            case 6:
                map.put(secondWord, map.getOrDefault(secondWord, 0) + 2);
                map.put(firstWord, map.getOrDefault(firstWord, 0));
                break;
            case 7:
                map.put(secondWord, map.getOrDefault(secondWord, 0) + 3);
                map.put(firstWord, map.getOrDefault(firstWord, 0));
                break;
        }
    }

    public static void main(String[] args) {
        kang_성격유형검사하기 test = new kang_성격유형검사하기();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(test.solution(survey, choices));

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};
        System.out.println(test.solution(survey2, choices2));
    }
}
