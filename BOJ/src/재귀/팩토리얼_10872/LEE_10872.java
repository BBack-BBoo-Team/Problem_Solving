package 재귀.팩토리얼_10872;

import java.util.Scanner;

public class LEE_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;

        for(int i=1; i<=N; i++){
            sum *= i;
        }

        /*
        int sum = N;
        for (int i=N-1; i>0; i--) {
            sum *= i;
        }
        */
        if (sum == 0) {
            System.out.println(1);
        } else {
            System.out.println(sum);
        }
    }
}