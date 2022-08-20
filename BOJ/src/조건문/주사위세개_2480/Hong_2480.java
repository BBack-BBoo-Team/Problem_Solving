package 조건문.주사위세개_2480;

import java.util.Scanner;

public class Hong_2480 {
    public static void main(String[] args) {
        System.out.println("주사위를 굴려 나온 1~6의 숫자 중 세 개를 띄어쓰기와 함께 입력하세요 (ex. 3 5 6)");
        Scanner input = new Scanner(System.in);

        int result = 0;
        int first = input.nextInt();
        int second = input.nextInt();
        int third = input.nextInt();

        //모든 수가 다를 때 사용할 최대값
        int[] maxnum = {first, second, third};
        int max = maxnum[0];
        for (int i = 0; i < maxnum.length; i++) {
            if (maxnum[i] > max) {
                max = maxnum[i];
            }
        }

        //3개의 수가 같을 때
        if (first == second && second == third && first == third) {
            result += first * 1000 + 10000;
        }
        //2개의 수가 같을 때
        else if (first == second || second == third || first == third) {
            if (first == second) {
                result += first * 100 + 1000;
            } else if (second == third) {
                result += second * 100 + 1000;
            } else if (first == third) {
                result += third * 100 + 1000;
            }
        }
        // 전부 다를 때
        else {
            result += max * 100;
        }
        System.out.println("상금 : " + result);
    }
}
