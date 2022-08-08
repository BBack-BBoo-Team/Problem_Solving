package 재귀.팩토리얼_10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 132ms
public class kang_10872 {

    public static int factorial(int num) {

        if(num == 0) {
            return 1;
        }
        return num * factorial(num-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }
}
