package 조건문.알람시계_2884;

import java.util.Scanner;
/*
1. h와m이 주어졌다. 이건 입력할 수 있는 Scanner만들기
2.입력할 수 있는 범위 지정해주기 0<=h<=23, 0<=m<=59
3.입력받은 m이 45이상이라면 m에 -45분 해주기
4.입력받은 m이 45이하 라면 h에서 1뻬주고 m에 15더해주기
5.!!!범위를 지정해주면 앞에서 코드가 끝날 수 있기 때문에 일단 정하지 않기!!!
6.만약 정한다면 제일 뒤에서 정해진 수를 벋어날때 전달할 문자적기
  ex)if(h > 24 && m > 60){
        System.out.println("시간이 아닙니다. 다시 입력하세요!!")

 */
public class LEE_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        if (m < 45) {  //여기서 h가 0이라면?? 이라는 문제를 해결해야 한다.24이상 이라면도 해결 해야한다.
            m = m + 15;
            if(0 == h) {
                h = 23;
            }else h --;
        }
        else if (m >= 45){
            m = m - 45;
        }
        System.out.println(h+ " "+m);
    }
}
