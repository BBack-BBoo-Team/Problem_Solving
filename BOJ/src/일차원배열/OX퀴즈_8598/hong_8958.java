package 일차원배열.OX퀴즈_8598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* OX퀴즈
time : 132 ms
memory : 14224 KB
*/

public class hong_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int caseT = Integer.parseInt(bf.readLine());   //테스트 횟수 입력 받기
        String[] arr = new String[caseT];     //테스트 케이스 크기의 배열 생성
        for (int i = 0; i < caseT; i++) {    //테스트케이스만큼 반복
            arr[i] = bf.readLine();          //배열에 각 행들을 넣어주기
        }

        for (int x = 0; x < arr.length; x++) {   //배열의 크기만큼 반복하기
            int count = 0;                      //정답일 때 카운트를 셀 변수 생성
            int sum = 0;                        //총 점수를 계산할 변수 생성
            for (int j = 0; j < arr[x].length(); j++) {     //배열의 값 ex) ooxxooo등을 하나씩 불러오기
                if (arr[x].charAt(j) == 'X') {              //값들이 x이면 0을 더하고
                    count = 0;                      //처음에 count+=0으로 했다가 계속 원하는 결과가 나오지 않음
                    //x라면 count를 0으로 만들고 sum에 넘긴 후 다시 for 문 돌기
                }else {       //값이 0이면 count++
                    count++;
                }
                sum += count;
            }
            System.out.println(sum);
        }
    }
}
