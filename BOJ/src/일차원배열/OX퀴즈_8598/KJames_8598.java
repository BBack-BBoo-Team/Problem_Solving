package 일차원배열.OX퀴즈_8598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * point
 * 1) BufferedReader
 * 2) StringTokenizer 를 통해 X 제거후 O 만 체크
 *
 * 수행시간 136ms
 */
public class KJames_8598 {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) { // 1. for : test case 만큼 반복

            // 문자 X를 기준으로 나눈 문자를 토큰으로 가짐
            st = new StringTokenizer(br.readLine(), "X");

            int total = 0; // 한 케이스에서 받을 총점 변수 초기화

            // 토큰이 있을 때 반복 진행
            while (st.hasMoreTokens()) {
                // 콘솔에 입력된 문자열을 토큰화
                // ex) 입력 OOXXOXXOOO -> OO O OOO
                // 첫 번째 token 에 할당되는 값 : 00
                // 두 번째 token 에 할당되는 값 : 0
                // 세 번째 token 에 할당되는 값 : 000
                String token = st.nextToken();

                int Point = 0; // 연속적인 O의 점수를 받을 변수

                // token 문자열의 길이가 즉 연속적인 O의 개수
                // token 이 OO 라면, 길이는 2이며, 1점+2점 : 총점 3점
                for (int j = 0; j < token.length(); j++) {
                    Point++;
                    total += Point;
                }
            }

            System.out.println(total);
        }
    }
}
