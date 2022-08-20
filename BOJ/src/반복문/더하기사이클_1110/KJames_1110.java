package 반복문.더하기사이클_1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * 1) 입력한 값(N)의 1의 자리와 10의 자리를 더함
 * 2) 더한 결과의 1의 자리와 방금 전 입력한 값의 1의 자리에서 10을 곱한뒤 더함
 * 3) 그렇게 새로운 수를 만듦 -> 길이 +1
 * 4) 새로운 수가 초기에 입력했던 N값과 동일하지면 종료
 *
 * 수행시간 128ms
 */
public class KJames_1110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int initial = N; // 입력값 초기값 저장

        br.close();

        // 조건에 도달하기 전까지 무한 반복
        while(true) {

            int units = N % 10; // 1의 자리
            N /= 10;
            int tens = N % 10; // 10의 자리

            int sum = units + tens; // 1) 1의 자리와 10의 자리를 더함

            N = (units * 10) + (sum % 10); // 2) 더한 결과의 1의 자리와 방금 전 입력한 값의 1의 자리에서 10을 곱한뒤 더함

            if(initial == N) { // 4) 새로운 수가 초기에 입력했던 N값과 동일하지면 종료
                count++; // 새로운 수까지의 길이기 때문에 마지막에도 +1
                break;
            }

            count++; // 3) 새로운 수를 만들면 길이 +1
        }

        System.out.println(count);
    }
}
