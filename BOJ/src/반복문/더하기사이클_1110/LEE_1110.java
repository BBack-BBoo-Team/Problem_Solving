package Bj;

import java.util.Scanner;
/*
1.범위 정하기
2.1의 자리 숫자라면 입력값에 10 곱하기
2. 26을 "2","6"으로 나누고 뒤의 수를 담는 그릇 만들기
3."2" + "6"을 한 값 "8"
4.앞에 담아둔 "6" +"8"하기
5.원래 값이랑 비교해서 맞으면 반복 횟수 프린트 아니라면 2번 부터 다시 진행

이건 아스키 코드 써야 하니까 패스


 */


public class Bj_1110 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        int cnt = 0;
        int copy = N;

        while (true) {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            cnt++;

            if (copy == N) {
                break;
            }
        }
        System.out.println(cnt);
    }
}


/*  이게 하다가 안된거 ㅡㅡ
public class Bj_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int num = 0;
        int b = a;
        while (true){
            b = ((a%10)*10) + ((a/10)+(a%10));
            num++;

            if(b == a){
                break;
            }
        }
        System.out.println(num);


    }
}

 */
        /* String ->int
        String str = "30";
        String a = "2";
        int i = Integer.parseInt(str);
        int b = Integer.parseInt(a);
        System.out.println(i+b);
        */

        /* int ->String으로
        int i = 30;
        String str = String.valueOf(i);
        System.out.println(str);
        */
