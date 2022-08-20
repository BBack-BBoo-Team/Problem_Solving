package 재귀.하노이탑_이동_순서_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있음
 * 2. 쌓아 놓은 원판은 내림차순이어야만 함
 *
 * 628ms
 */
public class Kang_11729 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 원판 개수
        br.close();

        sb.append((int)Math.pow(2,N)-1).append('\n'); // 옮긴 횟수 출력

        hanoi(N,1,2,3);
        System.out.println(sb);
    }

    public static void hanoi(int N, int start,int temp ,int end) {

        if(N==1){
            sb.append(start+ " " + end).append('\n');
            return;
        }

        hanoi(N-1,start,end,temp);
        sb.append(start + " " + end).append('\n');
        hanoi(N-1,temp,start,end);
    }
}
