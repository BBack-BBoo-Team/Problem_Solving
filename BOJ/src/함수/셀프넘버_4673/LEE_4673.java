package 함수.셀프넘버_4673;
/*
메모리 13992KB
시간 128ms
 */
public class LEE_4673 {

    public static void main(String[] args) {  //메인

        boolean[] check = new boolean[10001];	// 1부터 10000이므로

        for (int i = 1; i < 10001; i++){
            int n = d(i);

            if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
                check[n] = true;
            }
        }   //여기까지 범위지정 해주고 d의 값 다 넣어 주기  10000이하의 수

        StringBuilder sb = new StringBuilder(); //StringBuilder = 병경가능한 문자열 만듬 메모리 문제 해결가능
        //String을 더하는 행위에서의 메모리를 많이 잡아먹는데 이를 줄일 수 있다. 문자열을 더할때 새로운 객체를 만들지 않음 (기존 데이터에 더하는 방식)
        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {	// false 인 인덱스만 출력
                sb.append(i).append('\n'); //줄바꿈해서 넣어주기
            }
        }
        System.out.println(sb);   //String타입의 셀프넘버만 불바꿔서 출력
    }



    public static int d(int number){   //함수  /number를 생성자로 하는 수를 리턴시킬 꺼니까 sum변수 만들기
        int sum = number; // 1238,1241,1243,1244 순으로 오름

        while(number != 0){              //셀프 넘버를 찾기위한 반복문 작성
            sum = sum + (number % 10); // 첫 째 자리수  ex) 1234 = 1234 + (1234의 나머지인 4)
            number = number/10;	// 10을 나누어 첫 째 자리를 없앤다 ex)1238 = 123
        }

        return sum;  //return된 수는 생성자가 있는 수 이다. 출력하면 안되는 수
    }
}