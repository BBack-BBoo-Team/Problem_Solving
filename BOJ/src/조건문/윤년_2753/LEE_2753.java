package 조건문.윤년_2753;

import java.util.Scanner;

/*
1.범위설정 하기  1<=y<=4000
2.안되는 년도들 먼저 제외시키기 y%4 == 0, y%100 !== 0, y%400 ==0
3.불가능한 년도들 "0"으로 반환하기 (나머지 전부 가능하니까 "0"반환)
*/
public class LEE_2753 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int y= sc.nextInt();


        if(1 <= y && y <= 4000){
            if(y%4 == 0 && y%100 != 0){
                System.out.println("1");
            } else if (y%400 == 0) {
                System.out.println("1");
            }
            else System.out.println("0");
        }
    }
}