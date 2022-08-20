package 반복문.별찍기2_2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 별찍기_2
 *  point
 *  1) 2중 for 문 사용
 *
 *  수행시간 148ms
 */
public class KJames_2439 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 줄의 수인 N 입력
        int N = Integer.parseInt(br.readLine());
        String star = ""; // 별

        for (int i = 0; i < N; i++) { // first for

            // 공백 문자열
            String space = "";
            star += "*";

            for(int j = 1; j < N-i; j++) { // second for

                space += " ";
            }

            System.out.println(space + star);
        }
    }
}
