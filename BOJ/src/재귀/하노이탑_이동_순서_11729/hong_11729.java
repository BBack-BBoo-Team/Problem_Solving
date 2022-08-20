package 재귀.하노이탑_이동_순서_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 하노이 탑 이동 순서
time : 424 ms
memory : 59960 KB
 */
/*
1. 원반은 한번에 하나씩만 옮길 수 있음
2. 큰 원반 위에 작은 원반이 올라오게끔 해야함
 */
public class hong_11729 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        move(num, 1,2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void move(int num, int from, int other, int to) {  //from은 출발지(A기둥), other은 중간지점 (B기둥), to는 목적지 (C기둥_
        if( num == 0 ){
            return;
        }
        count ++;
        move(num-1, from, to, other);  //가장 큰 것을 제외한 나머지 n-1개를 목적지가 아닌 다른 곳으로 옮김(other로)
        sb.append(from + " " + to + "\n");  //가장 마지막 원반인(가장 큰) 원반을 목적지로 옮김
        move(num-1, other, from, to);  //다른 곳으로 옮겨 노왔던 원반들을 다시 목적지로 옮김
    }
}
