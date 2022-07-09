package 문자열.그룹단어체크_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hong_1316_실패 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());    //문자 입력 개수 받기
        int count = 0;                                 //나가 떨어진 문자가 아니라면 숫자를 카운트할 변수 선언

        for(int x=0; x<num; x++) {    //입력받은 개수만큼 반복할 것
            String str = bf.readLine();    //첫번째로 쓰여진 문자를 읽어서
            ArrayList<String> ar = new ArrayList<>();
            ar.add(String.valueOf(str.charAt(0)));    //그 문자의 첫번째 글자를 ar에 넣음

            for (int i = 1; i < str.length(); i++) {      //문자끼리의 비교
                String temp = String.valueOf(str.charAt(i));  //문자의 두번째 글자부터 시작
                if (!ar.contains(temp)) {
                    if(ar.get(ar.size()-1).equals(temp)){//ex) ABBA가 있다면 : ar에 이미 A가 들어있고 두번째 글자인 B와 비교
                        ar.add(temp);
                    } else {
                        break;
                    }
                } else break;
            }
            count++;
        }
        System.out.println(count);
    }
}

