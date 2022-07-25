package 기본수학1.설탕배달_2839;

import java.util.Scanner;

public class LEE_2839 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();


        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}

//17은??? 왜 -1이 나오나!!!

