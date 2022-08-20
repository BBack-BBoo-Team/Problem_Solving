package 기본수학1.설탕배달_2839;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 설탕 배달
time : 140 ms
memory : 14228 KB
 */
public class hong_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        //3과 5만으로 만들어 저야 함 -> 5의 배수가 아니라면 3을 지워가면서 5의 배수 만들기
        //3과 5으로 나누어 지지 않으면 -1 반환
        //가장 큰 봉지인 5kg을 먼저 사용하고 나머지를 3kg으로 채우는게 best 최적 !

        int count = 0; //설탕봉지의 개수를 셀 count 변수 선언

        while (num > 0) {  //num이 0이 될 떄 까지 반복
            if (num % 5 == 0) {  //만약 어떤 수가 5의 배수라면
                count = count + num/5;  //현재 있던 count에 수를 5로 나눈 몫을 더해줌
                num = 0;  //num을 0으로 바꿔주고 종료 !
                //바꿔주는 이유는 ? num이 15였을때 5로 나눠주면 몫이 3이라 count에 3이 저장되고
                // break문이 종료됨 --> 그러면 num이 3이라서 밑에 if문 (num!=0)에 들어감
                //-> 때문에 필요한 연산식
                break;
            }
            else {
                num = num - 3;  //5의 배수가 아니라면 3kg으로 count해주고 3씩 빼주고 반복하기
                count++;
            }
        }
        if (num != 0){  //위 과정을 반복하더라도 num의 나머지가 0이 아니면 3과 5의 설탕봉지로 채울 수 없음
            count = -1;  //때문에 -1 반환
        }
        System.out.println(count);
    }
}
