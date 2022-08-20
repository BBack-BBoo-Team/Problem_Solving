package 문자열.단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * point
 * 1) 대소문자 구분 x
 * 2) 가장 많이 사용된 알파벳이 2개 이상이면 ? 출력
 * 3) 출력은 대문자
 * <p>
 * idea
 * 1) 알파벳 개수만큼의 배열을 만들고, 각 인덱스를 대문자의 아스키코드와 동일하게 만들어보자!
 * 2) A-65 ~ Z-90
 * 3) 각 문자의 65를 뺀다면? 배열의 인덱스 0번 A, 25번 Z에 해당
 * 5) 입력받은 문자의 알파벳에서 65를 뺀 인덱스에 +1
 */
public class Kang_1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toUpperCase(); // 입력 받은 문자열을 모두 대문자화

        int[] alphabet = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int arrayIndex = input.charAt(i) - 'A';
            alphabet[arrayIndex]++;
        }

        int maxAlphabetIndex = 0;
        char result = (char) (maxAlphabetIndex + 'A');

        for (int index = 1; index < alphabet.length; index++) {

            if (alphabet[maxAlphabetIndex] < alphabet[index]) {
                maxAlphabetIndex = index;
                result = (char) (maxAlphabetIndex + 'A');
            } else if (alphabet[maxAlphabetIndex] == alphabet[index]) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
