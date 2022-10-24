package level1;

import java.util.ArrayList;
import java.util.Collections;

public class kang_정수내림차순으로배치하기 {

    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> numberArr = new ArrayList<Long>();
        while(n > 0) {
            numberArr.add(n%10);
            n /= 10;
        }

        Collections.sort(numberArr);
        answer = numberArr.get(0);

        for(int i = 1; i < numberArr.size(); i++) {
            answer += numberArr.get(i) * Math.pow(10, i);
        }

        return answer;
    }
}
