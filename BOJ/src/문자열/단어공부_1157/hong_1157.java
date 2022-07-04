package 문자열.단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 글자 공부
time : 288 ms
memory : 21040 KB
 */
public class hong_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String st = bf.readLine().toUpperCase();

        int max = 0;  //최대값을 구할 변수
        int alpha = 0;  //알파벳을 출력하기 위해 선언해주는 변수

        int English[] = new int[26];  //알파벳 들어갈 배열 선언\
        /* 입력받은 글의 각 글자가 해당하는 배열 인덱스에 더하기 해주기 */
        for(int i=0; i<st.length(); i++) {
            English[(st.charAt(i)-65)]++;   //알파벳 위치에 해당하는 열에 카운트 해줌 ! (아스키코드이기 때문에 -65)
            //즉, st.charAt이 A일때 A에 해당하는 열에 1 을 더해줌
        }
        /* 최대값(max)을 찾고 그 최대값에 해당하는 배열의 인덱스(num)를 저장 */
        for(int i=0; i<English.length; i++){
            if(English[i] > max){
                max = English[i];
                alpha = i;
            }
        }
        /* 최대값을 갖는 인덱스가 두 개 이상인지 찾기 */
        int maxCount = 0;
        for(int x=0; x<English.length; x++){
            if(max == English[x]){
                maxCount ++;
            }
        }
        /* 최대값이 2개 이상이면 ? 를, 아니라면 해당하는 알파벳을 출력 */
        if(maxCount >= 2) {
            System.out.println("?");
        } else {
            System.out.println((char) (alpha+65));
        }
    }
}
/* 아스키코드
숫자 <-> 문자를 위한 인코딩 방법으로 숫자를 문자로 대응시킨 코드
문자 A는 아스키코드 값으로 65를 가지고 있음
 */