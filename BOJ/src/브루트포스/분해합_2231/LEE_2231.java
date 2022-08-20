package 브루트포스.분해합_2231;

import java.util.Scanner;

public class LEE_2231 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();                // 216
        int result = 0;                      // 최종 출력될 값

        for (int i = 1; i < N; i++) {
            int sum = 0;                     // 다 더한 값  ex)198 = 1+9+8
            int num = i;                     // 그냥 i     ex)198

            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }

            if (sum + i == N) {              // 여기서 i를 더해주지 않아 한참 고생
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
