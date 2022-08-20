package 일차원배열.OX퀴즈_8598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주석 제거
public class KJames_8598_code {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {

            st = new StringTokenizer(br.readLine(), "X");

            int total = 0;

            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                int Point = 0;

                for (int j = 0; j < token.length(); j++) {
                    Point++;
                    total += Point;
                }
            }
            System.out.println(total);
        }
    }
}
