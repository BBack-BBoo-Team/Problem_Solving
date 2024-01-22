import java.util.*;

public class 팰린드롬의경우수 {

    int n;
    ArrayList<String> result;
    Deque<Character> temp;
    HashMap<Character, Integer> map;
    // 1) 문자 각각에 대한 갯수를 HashMap에 저장
    // 2) 홀수가 2개 이상이면 {} 리턴 후 종료
    // 3) 홀수가 1개면 1개 가운데 저장 -> Deque 활용 -> hashMap에서 저장한 문자 제거
    // 4) 짝수라면 그냥 진행
    public String[] solution(String s){
        n = s.length();
        String[] answer = {};
        result = new ArrayList<>();
        temp = new LinkedList<>();
        map = new HashMap<>();

        // 문자별 갯수 저장
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        // 홀,짝 체크
        int cnt = (int) map.keySet().stream().filter(a->map.get(a)%2!=0).count();
        if(cnt>=2) return answer;
        else if(cnt==1) map.keySet().stream().filter(a->map.get(a)%2!=0).forEach(c->temp.offer(c));

        dfs();
        answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    // dfs
    private void dfs() {

        // deque 사이즈가 s랑 같으면 result에 저장 후 리턴
        if(temp.size()==n) {
            StringBuilder sb = new StringBuilder();
            for(char ch : temp) {
                    sb.append(ch);
            }
            result.add(String.valueOf(sb));
            return;
        }

        // hashmap 데이터 순회
        for(char ch : map.keySet()) {
            // 현재 키의 값이 0개면 패스
            if(map.get(ch)==0) continue;
            // 2개 이상이면 deque에 앞 뒤로 데이터를 저장하고 hashmap에서 2빼기
            temp.addFirst(ch);
            temp.addLast(ch);
            map.put(ch, map.get(ch)-2);
            dfs();
            temp.pollFirst();
            temp.pollLast();
            map.put(ch, map.get(ch)+2);
        }
    }

    public static void main(String[] args){
        팰린드롬의경우수 T = new 팰린드롬의경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }

}
