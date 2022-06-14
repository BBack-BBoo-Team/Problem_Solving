package 일차원배열.최댓값_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제 : 최댓값과 위치 찾기
 * 조건 : 9개의 서로 다른 자연수
 * <p>
 * point
 * 1) 입력받은 값 배열에 담기
 * 2) 순회하며 최댓값을 찾고, 해당 인덱스 반환
 * <p>
 * 수행시간 148ms
 */
public class KJames_2562 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numberArr = new int[9];

        // 1) 9번 입력 받으면서 곧바로 배열에 입력
        for (int i = 0; i < numberArr.length; i++) {

            numberArr[i] = Integer.parseInt(br.readLine());
        }

        int maxNum = numberArr[0]; // 최댓값 초기화
        int maxIndex = 0; // 최댓값 인덱스

        // 2) 순회하며 최댓값을 찾고, 해당 인덱스 반환
        for (int i = 1; i < numberArr.length; i++) {

            if (numberArr[i] > maxNum) {
                maxNum = numberArr[i];
                maxIndex = i;
            }
        }

        System.out.println(maxNum + "\n" + (maxIndex + 1));
    }
}
