package 문자열.그룹단어체크_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hong_1316 {
/* 그룹 단어 체커
time : 132ms
memory :14244KB
어렵다 쒸
 */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());    //문자 입력 개수 받기
        int count = 0;                                 //나가 떨어진 문자가 아니라면 숫자를 카운트할 변수 선언

        for (int x = 0; x < num; x++) {    //입력받은 개수만큼 반복할 것
            String str = bf.readLine();
            char[] arr = new char[str.length()];
            int temp = 0;
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            } //입력받은 문자열을 char 단위로 쪼개어 arr에 저장

            /* 문자가 2라면 무조건 카운트 ! */
            if(str.length() <= 2) {
                count++;
                continue;
            }

            /* 그룹단어가 맞는지 아닌지 판단 */
            for (int j = 0; j < str.length()-1; j++) {
                if (arr[j] == arr[j + 1]) {   //j와 j+1번의 알파벳이 같으면 계쏙
                    continue;                   //ex) aabcd (aa라면 걔쏙, b를 만났을 때 밑으로)
                } else {                      //다르다면
                    for (int k = 0; k < j; k++) {     //다름이 발생한 인덱스2까지
                        if (arr[k] == arr[j + 1]) {  //arr[2]인 b가 되기 전인 arr[0]와 arr[1]에 b가 있는지 확인
                            temp++;         //같은게 있더라면 카운트 해주기 (0이되어야 앞에 동일한 것이 없음으로 간주)
                            break;
                        }
                    }
                }
            }
            if (temp == 0) {
                count++;     //temp가 0이라면 카운트해줌
            }

        }
        System.out.println(count);
    }
}


