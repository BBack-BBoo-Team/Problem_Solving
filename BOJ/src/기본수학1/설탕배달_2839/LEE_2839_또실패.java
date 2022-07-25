package 기본수학1.설탕배달_2839;

import java.util.Scanner;

public class LEE_2839_또실패 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();

            if(num % 5 == 0) {                          // 5로 나눠 떨어지면 5로 나눠서 출력.
                System.out.println(num / 5);
            }else if(num % 5 == 1 || num % 5 == 3) {    // 5로 나눴을 때 1,3 이면 +1
                System.out.println((num / 5) + 1);
            }else if(num % 5 == 2 || num % 5 == 4){     // 5로 나눴을 때 2,4면 +2
                System.out.println((num / 5) + 2);
            }else if(num % 3 == 0){                     // 3으로 나눠 떨어지면 3으로 나눠서 출력
                System.out.println(num/3);
            }else{
                System.out.println(-1);                // 모두 해당하지 않으면 -1??
            }
    }
}
        // 안걸리 수가 없네...... 미리 -1전제 조건을깔아야지 몰라.....
/* 1. 6이 왜 -1이 나올까?? 아 위에서 걸리네 아닌데...? 2 나와야함... --

 */