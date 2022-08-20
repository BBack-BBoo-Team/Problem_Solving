package 기본수학1.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 124ms
 */
public class KJames_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N %= 5;
            } else if (N == 1) {
                count = -1;
                break;
            } else {
                N -= 3;
                count++;
            }
        }

        System.out.println(count);
    }
}
