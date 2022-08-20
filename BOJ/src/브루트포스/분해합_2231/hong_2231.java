package 브루트포스.분해합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 분해합
time : 148 ms
memory : 14264 KB
 */
/*
1부터 입력받은 숫자까지 반복하기 !
1부터 각 자리수를 합해줘서 그 더한 값이 입력받은 숫자가 되면 종료
 */
public class hong_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        boolean result = false;

        for(int i=0; i<num; i++) {
            int base = i;
            int sum = i; //누적해서 더해줌

            while (base > 0) {
                sum += base % 10;  //각 자리수를 더하기
                base = base/10;
            }

            if(sum == num) {
                System.out.println(i);
                result = true;
                break;
            }
        }
        if(result == false){
            System.out.println(0);
        }
    }
}
/*
Q. 브루트 포스?
A. 완전 탐색 알고리즘
   가능한 모든 경우의 수를 모두 탐색하면서 요구 조건에 충족되는 결과만을 가져옴

   216을 입력하면 198이 되어야 함
   198 + 1 + 9 + 8 = 256이기 때문
 */
