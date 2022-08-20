package 브루트포스.분해합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 함수)셀프넘버와 유사한 느낌
 *
 * ? 왜 이렇게 어렵게 풀려고 했을까..?
 */
public class Kang_2231 {

    static ArrayList<Queue<Integer>> constructor;

    static void func(int N) {

        constructor = new ArrayList<>();

        // 자연수 범위 1부터 1,000,000까지 이므로 아래와 같이 범위 설정
        for(int i = 1; i < 1000001; i++) {
            constructor.add(new PriorityQueue<Integer>());
        }

        loop:
        for(int i = 1; i < constructor.size(); i++) {

            int num = i;
            int sumOfNum = num;

            while(num > 0) {
                sumOfNum += num%10;
                num /= 10;

                if(sumOfNum > constructor.size()) {
                    break loop;
                }
            }

            constructor.get(sumOfNum).add(i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        func(N);

        Integer result = constructor.get(N).poll();
        if(result==null) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
