package ex;


import java.util.Scanner;

public class LEE_0418 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int result = 0;

        if (a == b && b == c && a == c) {
            result = 10000 + a * 1000;
        }
        else if (a == b) {
            result = 1000 + a * 100;
        }
        else if (a == c){
            result = 1000 + a * 100;
        }
        else if (b == c) {
            result = 1000 + b * 100;
        }
        else {
            result = Math.max(a,  Math.max(b, c)) * 100;
        }
        System.out.println(result);
    }
}


