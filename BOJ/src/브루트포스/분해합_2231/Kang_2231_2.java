package 브루트포스.분해합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 140ms
public class Kang_2231_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1 부터 N-1까지 순회하며 분해합을 구했을 때, N과 동일할 때 해당 생성자를 출력
        for(int i = 1; i < N; i++) {

            int num = i;
            int sumOfNum = num;

            // 분해합을 구하는 과정
            while(num > 0) {
                sumOfNum += num%10;
                num /= 10;
            }

            // 분해합과 N이 동일하면, 생성자를 출력하고 그냥 바로 종료
            if(sumOfNum == N) {
                System.out.println(i);
                return;
            }
        }

        // 순회를 빠져나오면, N과 분해합이 동일한 값이 없다는 것 -> 생성자가 없다는 의미로 0출력
        System.out.println(0);
    }
}
