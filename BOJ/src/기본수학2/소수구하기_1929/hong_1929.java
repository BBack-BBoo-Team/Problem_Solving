package 기본수학2.소수구하기_1929;
/* 소수 구하기
time: 292ms
memory: 20972KB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 에라토스테네스(?) 원리 사용 ..
1. M과 N사이의 모든 수 중에서 2의 배수를 지움
2. 지워지지 않고 남아있는 수 중에서 제일 작은 수의 배수를 지움 (즉, 다음은 3의 배수)

* 숫자들이 소수인지 아닌지 판단하기 위해 true/false로 배열을 만듦 (소수면 false, 소수가 아니면 true)
* false로 초기화 된 배열에서 소수가 아닌 것을 true로 바꾸어주고 false인 것만 추출하게 !
 */

public class hong_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //sb에 담아 출력하기 위해 선언
        StringBuilder sb= new StringBuilder();

        //소수 판별 배열을 N까지 나타내기 위해 N+1을 범위로 지정
        boolean[] arr = new boolean[N+1];

        //0과 1은 소수가 아님
        arr[0] = true;
        arr[1] = true;

        //** 여기서 i<=N하니간 ArrayIndexOutofBounds 런타임 에러 발생
        //** i*i로 바꾸니깐 성공하긴 했지만 이유는 모르겠다 ....
        for(int i=2; i*i<=N; i++){
            //소수일 때 = i가 소수라면
            if(arr[i]==false){
                //k는 i에 대한 배수들이 들어옴 !!
                for(int k = i*i; k <= N; k+=i){
                    arr[k] = true; //i에 대한 배수는 소수가 아니기 때문에 true로 변경
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i]==false) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
