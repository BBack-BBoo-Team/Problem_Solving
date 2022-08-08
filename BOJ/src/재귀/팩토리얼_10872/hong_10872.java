package 재귀.팩토리얼_10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 팩토리얼
time : 124ms
memory : 14088KB
 */

public class hong_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int result = factorial(num);
        System.out.println(result);
    }
    public static int factorial(int num){
        if(num <= 1){
            return 1;
        }
        return num * factorial(num-1);
    }
}
