package 조건문.윤년_2753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 수행시간 128ms
 */
public class KJames_2753 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        // 4의 배수이면서 100의 배수가 아닐 때
        if(year % 4 == 0 && year % 100 != 0) {

            System.out.println(1);

        // 400의 배수일 때 , ex: 2000년
        } else if(year % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
