package 기본수학1.달팽이는올라가고싶다_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 달팽이는 올라가고 싶다
time : 128 ms
memory : 14212 KB
 */

public class hong_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());  //낮 +
        int B = Integer.parseInt(st.nextToken()); //밤 -
        int V = Integer.parseInt(st.nextToken()); //높이
        //마지막 날에는 미끄러지는 부분이 없는 것으로 결과적인 목표는 V-B인 꼴 !!
        int base = V - B;  //정싱에 도달했을 때 미끄러지지 않기 때문에 즉, 계산이 수행되지 않도록 미리 미끄럼을 빼줌
        int date = A - B;  //하루에 올라간 거리 : up - down
        int result = base / date;

        if (base % date != 0){
            result += 1;
            //정확히 나누어 떨어지지 않는다면 하루를 더 올라간 셈이니깐 +1 해주기
        }
        System.out.println(result);
    }
}
/*
3 1 7 일 때, 결과는 3
7 / (3 - 1) = 3.XXX
(7 - 1) / (3 - 1) = 3
 */