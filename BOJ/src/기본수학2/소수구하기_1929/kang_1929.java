package 기본수학2.소수구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

// 496ms
// 1부터 1000001 까지 소수인지 아닌지 판별하는 배열을 미리 만듦
// main 메서드에서 M과 N을 입력하면 해당 범위 내에서 true인 인덱스만 출력
public class kang_1929 {

    static boolean[] primeNum = new boolean[1000001];
    // true -> 소수
    // false -> 소수 X

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 배열의 인덱스가 소수면 true, 아니라면 false
    public static void primeFunc() {
        for(int i = 2; i < primeNum.length; i++) {
            boolean find = false; // 소수가 아님 -> true
            if(i>3) {
                for(int j =2; j <= sqrt(i); j++) {

                    // 소수가 아님
                    if(i % j == 0) {
                        find = true;
                        break;
                    }
                }
            }
            if(!find) {
                primeNum[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        primeFunc();

        for(int i = M; i <= N; i++) {
            if(primeNum[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
