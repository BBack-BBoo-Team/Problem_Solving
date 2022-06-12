package 반복문.더하기사이클_1110;

import java.util.Scanner;

public class hong_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int temp = num;
        int count = 0;

        while (true) {
            int start = temp / 10;
            int end = temp % 10;
            int sum = start + end;

            temp = end * 10 + sum % 10;
            count++;

            if (num == temp) {
                break;
            }
        }
        System.out.println(count);
    }
}
