import java.util.HashSet;

// set 활용 풀이, O(N)
// 자료구조 set의 중복 제거 및 검색 기능을 활용했다는 점은 좋음. 그렇지만 시간복잡도는 동일하기 때문에 효율 차이는 크지않음
public class 최대길이연속수열2 {

    public int solution(int[] nums) {

        // nums 정보를 set에 저장
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);

        // set 순회
        int answer = 0;
        for(int v : set) {
            int cnt = 1;
            // 값-1 이 있으면 continue
            if(set.contains(v-1)) continue;
            // 없으면 while
            int next = v+1;
            while(set.contains(next)) {
                // 값+1이 set에 있으면 cnt
                cnt++;
                next += 1;
            }
            // cnt answer 중 큰 값 answer 저장
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

}
