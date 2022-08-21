package 재귀.칸토어의집합_4779;
/* 칸쵸의 집합
time : 300 ms
memory : 19364 KB
 */

import java.io.*;

/*
1. 칸토어 집합은 [0-1]사이의 실수 집합 -> 3등분
2. -의 개수는 3 ** N
3. 문자열을 3등분해서 가운데 문자열에 해당되는 부분을 공백으로 바꿈
 - 3등분하면 앞, 중간, 뒤의 세부분으로 나뉘며 앞과 뒤에 오는 문자가 동일하고 중간 부분은 공백
 */
public class hong_4779 {
    static int N;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //입력용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //출력용
        String str;
        while ((str=bf.readLine()) != null){  //
            N = Integer.parseInt(str);
            int num = (int) Math.pow(3, N);  //3의 제곱을 의미 !
            arr = new char[num];  // 그 값만큼 배열 생성 n이 3이라면 27개의 배열 생성

            for(int i=0; i<num; i++) {   //배열의 모든 값에 '-' 를 추가
                arr[i] = '-';
            }
            dfs(0, num); //재귀함수 실행 !! start가 0 이고 길이가 27로 시작

            for(int i=0; i<num; i++) {
                bw.write(arr[i]); //arr에 있는 값 출력
            }
            bw.write("\n"); //각 N이 끝날때마다 \n으로 줇꿈
            bw.flush();  //남아있는 데이터를 모두 출력시킴
        }
    }
    static void dfs(int start, int length) { //start가 0, length가 27일 때
        if (length < 3) {
            return;   //전체 길이가 3이 되었다는 것은 더 이상 쪼개질 수 없음을 의미 -> 리턴
        }
        for(int i = start + length/3; i < start + length/3*2; i++) { //가운데 부분을 공백으로
            arr[i] = ' ';  //0-8 + 9-17 + 18-26 일때 9-17을 공백으로 !
        }

        dfs(start, length/3); //앞 부분 (앞부분의 과정도 위처럼 진행)
        dfs(start + length/3*2, length/3); //뒷부분 (뒷부분의 과정도 위처럼 진행)
    }
}
