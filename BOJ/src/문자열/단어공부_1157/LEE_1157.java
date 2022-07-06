package 문자열.단어공부_1157;

import java.util.Scanner;

public class LEE_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];  //알파벳이 들어올 배열 만들기

        String a = sc.next().toUpperCase(); //입력받은 문자를 대문자로 바꾸기

        int max = -1;
        char st = '?'; // 63 인데 어차피 다른 값이 들어 올거라서 아무거나 지정하면된다.0도 가능

        for(int i=0; i<a.length(); i++){  // 입력된 단어 길이만큼 반복
            arr[a.charAt(i)-65]++;        // 입력된 단어에 해당 인덱스의 수를 1씩 증가시켜
            if(max<arr[a.charAt(i)-65]){  // 만약 해당 인덱스가 max보다 크다면 그 값을 max에 저장해라
                max = arr[a.charAt(i)-65];// 저장해라
                st = a.charAt(i);         // st에도 저장 char타입이라 변환 필요 없음
            }
            else if (max == arr[a.charAt(i)-65]) st = '?'; //근데 맥스 값과 같은 수의 a.char가 존대하면 st를 '?'로 출력해라
        }
        System.out.println(st);
    }
}
