package 반복문.별찍기2_2439;

/*
메모리 18500kb
시간 344m

1.입력받을 Scanner만들기
2.입력 가능 범위 지정해주기 0 <= c <= 100
3.배열 만드는 코드 작성 ,한줄 완성되면 줄바꾸는 코드 작성 (2중 for문 이용)
* */

import java.util.Scanner;

public class Lee_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        if (0 <= c && c <= 100) {                  // 범위 지정해 주기
            for (int i = 1; i <= c; i++) {         // i가 입력값(c)보다 작다면 계속 반복
                for (int j = 1; j <= c - i; j++) { // j가 c-i의 값보다 작다면 계속반복
                    System.out.print(" ");
                    //j가 증가한 만큼 공백이 입력된다.
                }
                for (int k = 1; k <= i; k++) {     //i만큼 *을 추가해준다
                    System.out.print("*");
                }
                System.out.println();              //첫번째 반복문을 다 돌고나면 줄바꿈
            } // 첫번째 for문의 i가 증가하면 두번째 for문의 공백이 줄어들고 3번째 for문의 *이 증가하는 구조
        }
    }
}

/*
println 신경 못써서 아주 고생했다
기본적인 줄바꿈인데 당연히 사용하는 설로 인식해 결과가 자꾸 세로로 나옴

i랑 j를 0으로 시작했는데 5를 입력하면 행과 열이 6이 나옴 i = 행, j = 열
 */