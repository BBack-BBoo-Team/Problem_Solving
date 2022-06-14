package 일차원배열.평균은넘겠지_4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제
 * 학생들의 성적 평균을 넘는 학생 비율 구하기 (소수점 셋째 자리까지 출력!)
 * point
 * 1) StringTokenizer 활용
 * 2) 소수점 셋째 자리 출력 함수 활용
 *
 * 수행시간 168ms
 */
public class KJames_4344 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        // 테스트 케이스만큼 반복
        for (int i = 0; i < testCase; i++) {

            String input = br.readLine(); // 문자열 입력, 학생 수부터 성적까지 한 줄씩 읽음

            String[] arr = input.split(" "); // 공백을 기준을 나눈 문자들을 배열에 저장
            int totalOfScore = 0; // 점수 총합

            // 배열[0]은 학생 수, 인덱스 1부터 성적
            for (int j = 1; j < arr.length; j++) {
                totalOfScore += Integer.parseInt(arr[j]);
            }

            int studentNum = Integer.parseInt(arr[0]); // 총 학생 수
            int count = 0; // 평균을 넘는 학생의 수

            int average = totalOfScore / studentNum; // 평균

            // 성적들을 순회하며 평균을 넘는 성적을 발견했을 때 count+1
            for (int j = 1; j < arr.length; j++) {
                if (Integer.parseInt(arr[j]) > average) {
                    count++;
                }
            }

            double result = (double) count / studentNum * 100; // % 이기 때문에 * 100

            // 지시자 사용을 위해 printf 사용
            // 소수점 셋째 자리를 구하기 위해서서 지시자 '%.3f' 사용
            // % 출력을 위해 %% 작성
            System.out.printf("%.3f" + "%%"+"\n", result);
        }
    }
}
