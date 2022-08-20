package 기본수학1.달팽이는올라가고싶다_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4 2 7
public class kang_2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int climbUp = Integer.parseInt(st.nextToken());
        int goDown = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int rest = (height-goDown) % (climbUp - goDown);
        int day = (height-goDown) / (climbUp - goDown);

        if(rest == 0) {

        } else if(climbUp == height) {
            day = 1;
        }
        else {
            day += 1;
        }

        System.out.println(day);
    }
}
