package 재귀.칸토어의집합_4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.pow;

/**
 * 3^N 개의 문자열
 * 분할 정복 전략에서 나누기 단계의 결과 출력
 *
 * 300ms
 */
public class Kang_4779 {

    static int[] line; // 문자열을 [0,1] 형태로 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input; // 입력이 없을 때까지 입력받기 위해 임시 변수 생성

        while ((input = br.readLine())!=null) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(input);
            int lineLength = (int) pow(3, N);
            line = new int[lineLength];

            divide(N,0, lineLength - 1);

            for (int i : line) {
                if (i == 1) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    /**
     *
     * @param N : 지수
     * @param start : 1(-)이 시작하는 위치
     * @param end : 1(-)이 끝나는 위치
     */
    static void divide(int N, int start, int end) {

        if (N == 0) {
            line[end] = 1;
            return;
        }

        int nextPower = N - 1;

        divide(nextPower, start, start+(int)pow(3, nextPower)-1);
        divide(nextPower,end-(int)pow(3, nextPower)+1, end);
    }
}
