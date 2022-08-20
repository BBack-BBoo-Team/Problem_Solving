package 브루트포스.블랙잭_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * N개 카드 중 3장을 선택할 때, 숫자 M을 넘지 않으면서 가장 근접한 합을 출력
 *
 * 172ms
 */
public class Kang_2798 {

    static StringTokenizer st;
    static int cardArr[]; // N개의 카드를 담을 배열
    static ArrayList<Integer> listOfSum; // 카드들의 합을 저장할 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cardArr = new int[N];
        listOfSum = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }

        blackJack(0, 0, 0);

        // stream 활용, M 이하 중 가장 큰 수 출력
        System.out.println(
                listOfSum.stream()
                        .filter(n -> n <= M)
                        .mapToInt(n -> n)
                        .max()
                        .getAsInt()
        );
    }

    static void blackJack(int index, int count, int sum) {

        if (count == 3) {
            listOfSum.add(sum);
            return;
        }

        for (int i = index; i < cardArr.length; i++) {
            sum += cardArr[i];
            count++;
            blackJack(++index, count, sum);
            count--;
            sum -= cardArr[i];
        }
    }
}
