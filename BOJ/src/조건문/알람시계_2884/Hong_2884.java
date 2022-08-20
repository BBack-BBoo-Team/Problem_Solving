package 조건문.알람시계_2884;

import java.util.Scanner;

public class Hong_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if(H==0){
            H = 24;
        }
        if(H >= 1 && H<=24) {
            int temp = (H * 60 + M) - 45;
            H = temp / 60;
            M = temp % 60;
            if(H==24){
                H = 0;
            }
        }
        System.out.println(H + " " + M);
    }
}
