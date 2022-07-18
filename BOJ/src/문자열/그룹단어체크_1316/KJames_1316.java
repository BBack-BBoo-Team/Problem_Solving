package 문자열.그룹단어체크_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수행시간 124ms
public class KJames_1316 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int countOfWord = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < countOfWord; i++) {

            String input = br.readLine();
            boolean groupWord = true;

            // loop 로 그룹화
            loop:
            for (int currIdx = 0; currIdx < input.length(); currIdx++) {

                for (int nextIdx = currIdx + 1; nextIdx < input.length(); nextIdx++) {

                    if (input.charAt(currIdx) == input.charAt(nextIdx)) {
                        if(nextIdx - currIdx > 1) {
                            groupWord = false;
                            break loop; // loop 에 속한 모든 for 문 종료
                        }
                        break;
                    }
                }
            }

            if (groupWord == true) {
                count++;
            }
        }

        System.out.println(count);
    }
}
