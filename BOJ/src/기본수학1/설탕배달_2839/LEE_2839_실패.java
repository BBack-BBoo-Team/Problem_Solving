package 기본수학1.설탕배달_2839;

import java.util.Scanner;
/*
    1. 5,3으로 나눠서 안 떨어지면 -1로 출력
    2. 5로 나눠 떨어진거 출력
    3. 5로 나누고 남은 수가 3으로 나눠지는거 출력
    4. 3으로 나누고 남은 수 출력
 */


public class LEE_2839_실패 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        if((num%5)%3 != 0) {          // 처음 5,3으로 나눴는데 나머지가 나오면 불가능! ex)12,14은 불가능해서 여기서 끝
            System.out.println(-1);
        }else if(num%5 == 0) {                      // 모든 수가 5로 나눠떨어지면
            System.out.println(num/5);              // 5로 나눈 수만큼 출력한다.
        }else if(num%5 != 0){                       // 만약 5로 나눠눴는데 나머지가 있다면
            System.out.println((num/5)+(num%5)/3);  // 5로나눈 수 + 5로나눈 나머지에 3을 나눈 수를 해준다.
        }else{                                      // 나머지는 3으로 나눈거니까 그냥 3으로 나눠 출력
            System.out.println(num/3);

        }
    }
}

// 문제는 6,12,21등등 5,8의 배수(16)가 아닌 3의 배수가 문제다!!
// 6이면 처음에 걸려서 나가버림 하지만 3으로 3번 나눠담을 수 있다!!! 그래서 그냥 6만 제외 해주면??
// 근데 16도 문제가 많다..... 5로 2번 나누고 3으로 2번 나누면 가능 이건 싹 갈아 엎자
