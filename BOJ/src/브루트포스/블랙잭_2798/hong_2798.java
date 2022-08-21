package 브루트포스.블랙잭_2798;

/* 블랙잭
time: 128 ms
memory: 14176 KB
모든 경우의 수를 대입해보며 조건에 만족하는 값 찾기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hong_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(bf.readLine()," ");
        int arr[] = new int[N];  //N 크기 만큼의 배열을 만들기
        for(int i=0; i<N; i++) {  //배열에 카드 숫자들을 담아놓기
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int result = 0;  //M과 가까운 세 숫자의 합을 담을 result 변수
        for (int a = 0; a < N; a++) { //첫 번째 카드
            for (int b = a + 1; b < N; b++) {  //두 번째 카드
                for (int c = b + 1; c < N; c++) { //세 번째 카드
                    int total = arr[a] + arr[b] + arr[c];  //카드들의 합 더해주기

                    if (total <= M ){  //그 합을 result에 계속 넣어주고 그 값이 다시 돌아오는 반복문의 total보다 크면 그대로, 작으면 바꿔주기
                        result = Math.max(result,total);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
